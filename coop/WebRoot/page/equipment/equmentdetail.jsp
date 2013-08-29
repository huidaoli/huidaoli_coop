<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="sys"  uri="http://www.can2to.com/sys/functions" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

		
	<script type="text/javascript">
		
	 $(function(){
	 
	    $("tr:odd").addClass("a1");
	    
	    $('.easyui-validatebox').validatebox({
            required:true
        });
 
 
        $('#p1').panel({
            width:650,
            height:120,
            title: '设备基本信息',
            collapsible:true,
            style:{"padding-top":"10px"}
        });
        
        $('#p2').panel({
            width:650,
            height:150,
            title: '设备分类数据',
            collapsible:true,
            style:{"padding-top":"10px"}
        });
        
        $('#p3').panel({
            width:650,
            height:150,
            title: '通用数据',
            collapsible:true,
            style:{"padding-top":"10px"}
        });
         
         $('#p4').panel({
            width:650,
            height:120,
            title: '购置数据',
            collapsible:true,
            style:{"padding-top":"10px"}
        });
         
         $('#p5').panel({
            width:650,
            height:200,
            title: '制造商数据',
            collapsible:true,
            style:{"padding-top":"10px"}
        });
         
         $('#p6').panel({
            width:650,
            height:180,
            title: '其他信息',
            collapsible:true,
            style:{"padding-top":"10px"}
        });
        
         $('#p7').panel({
            width:650,
            height:180,
            title: '已有资料信息',
            collapsible:true,
            style:{"padding-top":"10px"}
        });
        
         $('#p8').panel({
            width:650,
            height:380,
            title: '上传资料',
            collapsible:true,
            style:{"padding-top":"10px"}
        });
        
        $('#tt12').tabs({
						plain:true,
						onSelect:function(title)
						{
						  // alert(title);
						}
						
		});
			
		
	 })
	
	</script>

    
<form id="fm" method="post">
<div id="tt12">
			<div title="基本信息"  style="padding:10px;" >
								        <div id="p1" style="padding:10px;">
								<table width="100%" id="mytab1" border="1" class="t1">
								   <tr>
										<td nowrap="nowrap" width="100">
											设备名称:
										</td>
										<td>
										    <input type="text" name="equmentDetail.name" value="<s:property value="equmentDetail.name"/>"  class="easyui-validatebox" required="true" >
										</td>
										<td nowrap="nowrap">
											设备位号:
										</td>
										<td>
										    <input type="text" name="equmentDetail.weihao" value="<s:property value="equmentDetail.weihao"/>"  class="easyui-validatebox" required="true" >
										</td>
										
									</tr>
									<tr>
										<td nowrap="nowrap" width="100">
											ERP设备编号:
										</td>
										<td>
										    <input type="text" name="equmentDetail.bianhao" value="<s:property value="equmentDetail.bianhao"/>"  class="easyui-validatebox" required="true" >
										</td>
										<td nowrap="nowrap">
											WYBM:
										</td>
										<td>
										    <input type="text" name="equmentDetail.wybm" value="<s:property value="equmentDetail.wybm"/>"  class="easyui-validatebox" required="true" >
										</td>
										
									</tr>
							
								</table>
							</div>
						
					 <div id="p2" style="padding:10px;">
								<table width="100%" id="mytab2" border="1" class="t1">
								   <tr>
										<td nowrap="nowrap" width="100">
											设备分类:
										</td>
										<td>
										    <input type="text" name="equmentDetail.fenlei" value="<s:property value="equmentDetail.fenlei"/>"  class="easyui-validatebox" required="true" >
										</td>
										<td nowrap="nowrap">
											设备属于:
										</td>
										<td>
										    <input type="text" name="equmentDetail.shuyu" value="<s:property value="equmentDetail.shuyu"/>"  class="easyui-validatebox" required="true" >
										</td>
										
									</tr>
									<tr>
										<td nowrap="nowrap" width="100">
											ABC类别:
										</td>
										<td>
										    <input type="text" name="equmentDetail.abcleibie" value="<s:property value="equmentDetail.abcleibie"/>"  class="easyui-validatebox" required="true" >
										</td>
										<td nowrap="nowrap">
											型号:
										</td>
										<td>
										    <input type="checkbox" name="type" style="border:none">压力容器
										    <input type="checkbox" name="type" style="border:none">大机组
										    <input type="checkbox" name="type" style="border:none">大型关键容器
										</td>
										
									</tr>
									<tr>
										<td nowrap="nowrap" width="100">
											回路编号:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										<td nowrap="nowrap">
											流程图编号:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										
									</tr>
							
								</table>
							</div>
					
					
					<div id="p3" style="padding:10px;">
								<table width="100%" id="mytab3" border="1" class="t1">
								   <tr>
										<td nowrap="nowrap" width="100">
											重量:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										<td nowrap="nowrap">
											重量单位:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										
									</tr>
									<tr>
										<td nowrap="nowrap" width="100">
											投用日期:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										<td nowrap="nowrap">
											大小/尺长:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										
									</tr>
									<tr>
										<td nowrap="nowrap" width="100">
											固定资产号:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										<td nowrap="nowrap">
											按装原始记录编号:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										
									</tr>
							
								</table>
							</div>
					
						<div id="p4" style="padding:10px;">
							
							           	<table width="100%" id="mytab4" border="1" class="t1">
								   <tr>
										<td nowrap="nowrap" width="100">
											购置金额:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										<td nowrap="nowrap">
											购置单位:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										
									</tr>
									<tr>
										<td nowrap="nowrap" width="100">
											购置日期:
										</td>
										<td colspan="3">
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										
										
									</tr>
									
							
								</table>  
							
						</div>
						<div id="p5" style="padding:10px;">
							
							          <table width="100%" id="mytab5" border="1" class="t1">
								   <tr>
										<td nowrap="nowrap" width="100">
											制造商:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										<td nowrap="nowrap">
											制造商国家:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										
									</tr>
									<tr>
										<td nowrap="nowrap" width="100">
											制造年月:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										<td nowrap="nowrap">
											设备总装图号:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										
									</tr>
									<tr>
										<td nowrap="nowrap" width="100">
											出厂编号:
										</td>
										<td colspan="3">
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										
										
									</tr>
								   <tr>
										<td nowrap="nowrap" width="100">
											型号规格:
										</td>
										<td colspan="3">
										     <textarea style="width:350px;height:50px"></textarea>
										</td>
										
										
									</tr>
							
								</table>
							
							</div>
						<div id="p6" style="padding:10px;">
								 <table width="98%" id="mytab6" border="1" class="t1">
								   <tr>
										<td nowrap="nowrap" width="100">
											最后修改人:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										<td nowrap="nowrap">
											设备唯一标识符:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										
									</tr>
									<tr>
										<td nowrap="nowrap" width="100">
											顺序:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										<td nowrap="nowrap">
											保管员:
										</td>
										<td>
										    <input type="text" name="equmentDetail.title" value="<s:property value="equmentDetail.title"/>"  class="easyui-validatebox" required="true" >
										</td>
										
									</tr>
									<tr>
										<td nowrap="nowrap" width="100">
											备注:
										</td>
										<td colspan="3">
										    <textarea style="width:350px;height:50px"></textarea>
										</td>
										
										
									</tr>
								  
							
								</table>
						</div>
			</div>
			<div title="设备资料信息"  style="padding:10px;" >
			    
	<table border="0" cellspacing="1" class="fu_list">
    <thead>
      <tr>
        <td colspan="2"><b>上传文件</b></td>
      </tr>
    </thead>
    <tbody>
      <tr>
      
        <td><a href="javascript:void(0);" class="files" id="idFile"></a> <img id="idProcess" style="display:none;" src="img/loading.gif" /></td>
      </tr>
      <tr>
        <td colspan="2"><table>
            <thead>
            
            </thead>
            <tbody id="idFileList">
            </tbody>
          </table></td>
      </tr>
      <tr>
        <td colspan="2" style="color:gray">最多可同时上传10个文件。 </td>
      </tr>
      <tr>
        <td colspan="2" align="center" id="idMsg"><input type="button" value="开始上传" id="idBtnupload" />
         
        </td>
      </tr>
    </tbody>
  </table>
			    
			    
			</div>

</div>
         
</form> 
<script type="text/javascript">
 //根据list的length循环 将list数组的值分别传入到fun函数中执行
	var ForEach = function(list, fun){
		for (var i = 0, len = list.length; i < len; i++) { 
		     fun(list[i], i); 
		}
	};
	var Apply = function(object, fun) {
		return function() {
		   //将局部的函数赋给全局调用 ==>object的this 替换 fun的this
			return fun.apply(object, arguments);
		}
	}
	
	 function tAlert(title,msg)
		{
		     $.messager.alert(title,msg);
		}
	
	
    var FileUpload = {
          FileName:"file",
          FileId:"fileId",
          FileType:"file",
          Distinct:	true,//是否不允许相同文件
          Limit:5,
          imgwidth:100,
          imgheight:100,
          getFileLength:function(arr){return arr;},
          Folder:document.getElementById("idFile"),
          
	      initFun:function(){
	          this.Files = [];
	          ForEach(this.Folder.getElementsByTagName("input"), Apply(this, function(o){
					if(o.type == "file"){ o.value && this.Files.push(o);this.onIniFile(o) }
			  }));
			  var file = document.createElement("input");
			  file.name = this.FileName; 
			  file.type = this.FileType; 
			  file.id = this.FileId;
			  file.onchange =  Apply(this,function(){this.check(file);this.initFun();});
			  this.Folder.appendChild(file);
			  this.createData();
			  Apply(this,function(){this.getFileLength(this.Files)})
	      },
	      ExtIn:["gif","jpg","bmp","png","doc","xls","pdf"],
	      check:function(file){
	         //检测变量
	         var bCheck = true;
	         if(!file.value){
			    bCheck = false; this.onEmpty();
			 } else if(this.Limit && this.Files.length >= this.Limit){
					bCheck = false; this.onLimite();
				} else if(!!this.ExtIn.length && !RegExp("\.(" + this.ExtIn.join("|") + ")$", "i").test(file.value)){
					//检测是否允许后缀名
					bCheck = false; this.onNotExtIn();
				} else if(!!this.Distinct) {
					ForEach(this.Files, function(o){ if(o.value == file.value){ bCheck = false; } })
					if(!bCheck){ this.onSame(); }
				}
				//没有通过检测
				!bCheck && this.onFail(file);
	      },
	     
	onIniFile: function(file){ file.value ? file.style.display = "none" : this.Folder.removeChild(file); },
	onEmpty: function(){ tAlert("警告信息","请选择一个文件"); },
	onLimite: function(){ tAlert("警告信息","超过上传限制"); },
	onSame: function(){ tAlert("警告信息","已经有相同文件"); },
	onNotExtIn:	function(){ tAlert("警告信息","只允许上传" + this.ExtIn.join("，") + "文件"); },
	onFail: function(file){ this.Folder.removeChild(file); },
	      createData: function(){
			//显示文件列表
			var arrRows = [];
			if(this.Files.length){
				var oThis = this;
				ForEach(this.Files, function(o){
					var a = document.createElement("a"); a.href = "javascript:void(0);";
					a.innerHTML="<img src='../themes/icons/no.png' style='border:0'>";
					a.onclick = function(){ oThis.deleteO(o); return false; };
					arrRows.push([o.value, a]);
				});
			} 
			else {

		      arrRows.push(["<span id='fontid1'><font color='gray'>文件列表</font></span>"]); 
			   
			}
			this.addList(arrRows);
		 },
		 addList:function(rows){
			//根据数组来添加列表
			var FileList = document.getElementById("idFileList"), oFragment = document.createDocumentFragment();
			//用文档碎片保存列表
			ForEach(rows, function(cells){
				var row = document.createElement("tr");
				ForEach(cells, function(o){
					var cell = document.createElement("td");
					//alert(o);
					if(typeof o == "string"){ 
					   cell.innerHTML = o; 
					}else{ 
					   cell.appendChild(o);
					}
					row.appendChild(cell);
				});
				oFragment.appendChild(row);
			})
			//ie的table不支持innerHTML所以这样清空table
			while(FileList.hasChildNodes()){ FileList.removeChild(FileList.firstChild); }
			FileList.appendChild(oFragment);
		},
		deleteO: function(file) {
			//移除指定file
			this.Folder.removeChild(file); 
			this.initFun();
		},
		onIniFile: function(file){ 
		    file.value ? file.style.display = "none" : this.Folder.removeChild(file);
		},
		/**
		createImg: function(o){
	      var img = document.createElement("img");
	      //firfox
	      if(jQuery.browser.mozilla){
	          img.src = o.files.item(0).getAsDataURL();
	          img.className="imgcss";
	      }
	      //ie
	      if(jQuery.browser.msie){
	          img.src = o.value;
	          this.initImg(img);
	      }
	     
		  return img;
	        
	    },
	    initImg:function (img){
	       this.drawImg(img,this.imgwidth,this.imgheight);
        },
        **/
	    
	    getFlieName:function(s){
	       //var s= "c:/ssss/sdafs/sss.jpg";
			var array = s.split("\\");
			return array[array.length-1];
	    },
	    /**
	    drawImg:function(obj,boxWidth,boxHeight)
		{
		　　　 var imgWidth=obj.width;
		　　　 var imgHeight=obj.height;
		　　　 //比较imgBox的长宽比与img的长宽比大小
		　　　 if((boxWidth/boxHeight)>=(imgWidth/imgHeight))
		　　　 {
		　　　　　　　 //重新设置img的width和height
		　　　　　　　 obj.width=(boxHeight*imgWidth)/imgHeight;
		　　　　　　　 obj.height=boxHeight;
		　　　 }
		　　　 else
		　　　 {
		　　　　　　　 //重新设置img的width和height
		　　　　　　　 obj.width=boxWidth;
		　　　　　　　 obj.height=(boxWidth*imgHeight)/imgWidth;
		　　　 }
		},
		**/
		Clear: function() {
			ForEach(this.Files, Apply(this, function(o){ this.Folder.removeChild(o); })); this.initFun();
		},
		createIframe:function(){
			var frameName = "uploadFrame_" + Math.floor(Math.random() * 1000);
			var oFrame = jQuery.browser.msie ? document.createElement("<iframe name=\"" + frameName + "\">") : document.createElement("iframe");
			oFrame.name = frameName;
			oFrame.style.display = "none";
			document.body.insertBefore(oFrame, document.body.childNodes[0]);
			return frameName;
		},
	    version:"1.0"
    };
    FileUpload.initFun();
    



</script>


