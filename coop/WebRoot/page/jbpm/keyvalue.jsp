<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script>

$(function() {
			$('#tt12').datagrid({
				title : '属性值',
				iconCls : 'icon-edit',
				idField:'itemid', 
				nowrap: false,
				striped: true,
				width : 360,
				height : 260,
				singleSelect : true,
				columns : [[{field:'itemid',width:15},
				            {field:'key',title:'键',width:130,editor:{
				                type:'text',
							    options:{
								    required:true
								}
							}},
			            	{field:'value',title:'值',width:130,editor:'text'},
				            {
							field : 'action',
							title : '操作',
							width : 70,
							align : 'center',
							formatter : function(value, row, index) {
								if (row.editing) {
									var s = '<a href="#" onclick="saverow('
											+ index + ')">OK</a> ';
									var c = '<a href="#" onclick="cancelrow('
											+ index + ')">取消</a>';
									return s + c;
								} else {
									var e = '<a href="#" onclick="editrow('
											+ index + ')">编辑</a> ';
									var d = '<a href="#" onclick="deleterow('
											+ index + ')">删除</a>';
									return e + d;
								}
							}
						}]],
				onBeforeEdit : function(index, row) {
					row.editing = true;
					updateActions();
				},
				onAfterEdit : function(index, row) {
					row.editing = false;
					updateActions();
				},
				onCancelEdit : function(index, row) {
					row.editing = false;
					updateActions();
				}
			});
		});
function updateActions() {
	var rowcount = $('#tt12').datagrid('getRows').length;
	for (var i = 0; i < rowcount; i++) {
		$('#tt12').datagrid('updateRow', {
					index : i,
					row : {
						action : ''
					}
				});
	}
}
function editrow(index) {
	$('#tt12').datagrid('beginEdit', index);
}
function deleterow(index) {
	$.messager.confirm('信息', '确认删除?', function(r) {
				if (r) {
					$('#tt12').datagrid('deleteRow', index);
					updateActions();
				}
			});
}
function saverow(index) {
    var editkey = $('#tt12').datagrid('getEditor', {index:index,field:'key'});
    var editvalue = $('#tt12').datagrid('getEditor', {index:index,field:'value'});

    //save($(editkey.target).val(),$(editvalue.target).val())
    
	$('#tt12').datagrid('endEdit', index);
}
function cancelrow(index) {
	$('#tt12').datagrid('cancelEdit', index);
}
function insert() {
	var row = $('#tt12').datagrid('getSelected');
	if (row) {
		var index = $('#tt12').datagrid('getRowIndex', row);
	} else {
		index = 0;
	}
	$('#tt12').datagrid('insertRow', {
				index : index,
				row : {
					
				}
			});
	$('#tt12').datagrid('selectRow', index);
	$('#tt12').datagrid('beginEdit', index);
}


</script>
    
	<div style="margin: 10px 0">
		<a href="#" class="easyui-linkbutton" onclick="insert()">新增</a>
	</div>
	<table id="tt12"></table>
