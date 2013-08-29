function getUploadView(contcode, view, coop) {
    var url;
	if(coop)
	{
		url ='getAttaById.action?contcode=' + contcode + '&view='+ view+"&coop="+coop;
	}
	else
	{
	    url ='../upload/getAttaById.action?contcode=' + contcode + '&view='+ view;
	}
	var $divuploadview = $('<div id="dlguploadview" class="easyui-dialog" style="width:500px;height:450px;padding:10px 20px" closed="true">');
	var options = {
		title : '附件管理',
		modal : true,
		shadow : false,
		href : url,
		closed : false,
		onClose : function() {
			$('#dlguploadview').dialog('destroy')
		}
	}
	settings = {
		buttons : [{
					text : '关闭',
					handler : function() {
						// 调用dialog的close方法
						$('#dlguploadview').dialog('close');
					}
				}]
	}
	$.extend(options, settings);

	$divuploadview.dialog(options)

}

function getUpload(code) {

	var contcode;
	if (code) {
		contcode = code;
	} else {
		contcode = $('#contcodeid').val();
	}
	var $divupload = $('<div id="dlgupload" class="easyui-dialog" style="width:500px;height:450px;padding:10px 20px" closed="true">');
	var options = {
		title : '附件管理',
		modal : true,
		shadow : false,
		href : '../upload/toUpload.action',
		closed : false,
		onLoad : function() {
			$('#viewupload').html("<img src='../themes/icons/loading.gif'/>");
			$('#viewupload').load('../upload/getAttaById.action?contcode='
					+ contcode);
		},
		onClose : function() {
			// close方法触发的onClose事件,去调用destory方法
			$('#dlgupload').dialog('destroy')
		}
	}
	settings = {
		buttons : [{
			id : 'updid',
			text : '上传',
			iconCls : 'icon-ok',
			handler : function() {
				$('#updid').linkbutton('disable');
				savefile('../upload/savefile.action?contcode=' + contcode,
						contcode);

			}
		}, {
			text : '关闭',
			handler : function() {
				// 调用dialog的close方法
				$('#dlgupload').dialog('close');
			}
		}]
	}
	$.extend(options, settings);

	$divupload.dialog(options)

}

function checkfile() {
	var attafiles = document.getElementsByName("attafile");
	for (var i = 0; i < attafiles.length; i++) {
		if (attafiles[i].value == '') {
			$('#updid').linkbutton('enable');
			tAlert('信息', '附件不能为空')
			return false;
		}
	}

	return true;

}

function clearUp() {

	/***************************************************************************
	 * //IE 9 不支持 var attafiles = document.getElementsByName("attafile");
	 * alert(attafiles); for(var i=0;i<attafiles.length;i++) {
	 * attafiles[i].outerHTML=attafiles[i].outerHTML;
	 *  }
	 **************************************************************************/

	// 复制对象并清空值
	$("upfile").after($("upfile").clone(true).val(""));
	$("upfile").remove();

}

function savefile(url, code) {
	$('#fmatta').form('submit', {
		url : url,
		onSubmit : function() {
			return checkfile();
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.success) {
				// clearUp();
				$('#updid').linkbutton('enable');
				var contcode;
				if (code) {
					contcode = code;
				} else {
					contcode = $('#contcodeid').val();
				}
				$('#viewupload')
						.html("<img src='../themes/icons/loading.gif'/>");
				$('#viewupload').load('../upload/getAttaById.action?contcode='
						+ contcode);
				tAlert('信息', '保存成功');
				// $('#dlg').dialog('close');
				// $('#tt').datagrid('reload'); // reload the OpenClass data

			} else {
				tAlert('信息', '保存失败')
			}
		}
	});

}

function deleAtta(attaid) {
	$.messager.confirm('信息', '确认删除', function(r) {
		if (r) {
			$.post('../upload/deleAtta.action', {
						id : attaid
					}, function(result) {
						if (result.success) {
							var contcode = $('#contcodeid').val();
							$('#viewupload')
									.html("<img src='../themes/icons/loading.gif'/>");
							$('#viewupload')
									.load('../upload/getAttaById.action?contcode='
											+ contcode);
						} else {
							tAlert('信息', '删除失败');
						}
					}, 'json');
		}
	});

}