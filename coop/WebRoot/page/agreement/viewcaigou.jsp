<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script language="javascript">
$(function(){
  
    function gethtml(i)
    {
       var html ="<tr>";
	   html +="<td><input type=\"hidden\" name=\"agreement.item["+i+"].pcode\" id=\"pcode\" value=\"<s:property value="agreement.code"/>\">"+(i+1)+"</td>";
	   html +="<td><input type=\"text\" name=\"agreement.item["+i+"].proname\" id=\"proname\" style=\"width:100%;border:0;padding: 1px;\"></td>";
	   html +="<td><input type=\"text\" name=\"agreement.item["+i+"].guige\" id=\"guige\" style=\"width:100%;border:0;\"></td>";
	   html +="<td><input type=\"text\" name=\"agreement.item["+i+"].candi\" id=\"candi\" style=\"width:100%;border:0;\"></td>";
	   html +="<td><input type=\"text\" name=\"agreement.item["+i+"].shuliang\" id=\"shuliang\" style=\"width:100%;border:0;\"></td>";
	   html +="<td><input type=\"text\" name=\"agreement.item["+i+"].danjia\" id=\"danjia\" style=\"width:100%;border:0;\"></td>";
	   html +="<td><input type=\"text\" name=\"agreement.item["+i+"].xiaoji\" id=\"xiaoji\" style=\"width:100%;border:0;\"></td>";
	   html +="</tr>";
	   return html;
	}
	function gethtml2(i)
    {
       var html ="<tr>";
	   html +="<td>"+(i+1)+"</td>";
	   html +="<td><input type=\"text\" onclick=\"WdatePicker();\" name=\"agreement.item["+i+"].jhsj\" id=\"jhsj\" style=\"width:100%;border:0;padding: 1px;\"></td>";
	   html +="<td><input type=\"text\" name=\"agreement.item["+i+"].jhdd\" id=\"jhdd\" style=\"width:100%;border:0;\"></td>";
	   html +="<td><input type=\"text\" name=\"agreement.item["+i+"].jflxr\" id=\"jflxr\" style=\"width:100%;border:0;\"></td>";
	   html +="<td><input type=\"text\" name=\"agreement.item["+i+"].lxdh\" id=\"lxdh\" style=\"width:100%;border:0;\"></td>";
	   html +="<td><input type=\"text\" name=\"agreement.item["+i+"].bz\" id=\"bz\" style=\"width:100%;border:0;\"></td>";
	   html +="</tr>";
	   return html;
	}   
    for(var i=0;i<10;i++)
    {
       $("#mytab").append(gethtml(i));
       $("#mytab1").append(gethtml2(i));
    }
    $("#mytab").append("<tr><td colspan=\"3\"></td><td>数量合计:</td><td><input type=\"text\" name=\"agreement.ext.shuliangheji\" id=\"shuliangheji\" style=\"width:100%;border:0;\"></td><td>金额合计:</td><td><input type=\"text\" name=\"agreement.ext.jineheji\" id=\"jineheji\" style=\"width:100%;border:0;\"></td></tr>");
})


function checkform1()
{
   //合同名称
   var hetitle = $('#hetitle');
   //编号
   var heno = $('#heno');
   //甲方
   var jiafang = $('#jiafangtext');
   //乙方
   var yifang = $('#yifang');
   
   
   
   if($.trim(hetitle.val())=='')
   {
       hetitle.focus();
       alert('标题不能为空');
       return false;
   }
   if($.trim(heno.val())=='')
   {
       heno.focus();
       alert('编号不能为空');
       return false;
   }
   if($.trim(jiafang.val())=='')
   {
       jiafang.focus();
       alert('甲方不能为空');
       return false;
   }
   if($.trim(yifang.val())=='')
   {
       yifang.focus();
       alert('乙方不能为空');
       return false;
   }
   
   var proname = $("input[name$='proname']");
   var guige = $("input[name$='guige']");
   var candi = $("input[name$='candi']");
   var shuliang = $("input[name$='shuliang']");
   var danjia = $("input[name$='danjia']");
   var xiaoji = $("input[name$='xiaoji']");
   for(i=0;i<proname.size();i++)
   {
       if(i==0){
        
	        if($.trim(proname.get(i).value)=='')
	        {
	           proname.get(i).focus();
	           alert("采购清单,第"+(i+1)+"行 品名不能为空");
	           return false;
	        }
	        if($.trim(guige.get(i).value)=='')
	        {
	           guige.get(i).focus();
	           alert("采购清单,第"+(i+1)+"行 规格不能为空");
	           return false;
	        }
	        if($.trim(candi.get(i).value)=='')
	        {
	           candi.get(i).focus();
	           alert("采购清单,第"+(i+1)+"行 产地不能为空");
	           return false;
	        }
	        if($.trim(shuliang.get(i).value)=='')
	        {
	           shuliang.get(i).focus();
	           alert("采购清单,第"+(i+1)+"行 数量不能为空");
	           return false;
	        }
	        if($.trim(danjia.get(i).value)=='')
	        {
	           danjia.get(i).focus();
	           alert("采购清单,第"+(i+1)+"行 单价不能为空");
	           return false;
	        }
	         if($.trim(xiaoji.get(i).value)=='')
	        {
	           xiaoji.get(i).focus();
	           alert("采购清单,第"+(i+1)+"行 小计不能为空");
	           return false;
	        }
      }
      else
      {
            if($.trim(proname.get(i).value)!='' || $.trim(guige.get(i).value)!='' || $.trim(candi.get(i).value)!='' || 
            $.trim(shuliang.get(i).value)!='' || $.trim(danjia.get(i).value)!=''|| $.trim(xiaoji.get(i).value)!='')
            {
                    if($.trim(proname.get(i).value)=='')
			        {
			           proname.get(i).focus();
			           alert("采购清单,第"+(i+1)+"行 品名不能为空");
			           return false;
			        }
			        if($.trim(guige.get(i).value)=='')
			        {
			           guige.get(i).focus();
			           alert("采购清单,第"+(i+1)+"行 规格不能为空");
			           return false;
			        }
			        if($.trim(candi.get(i).value)=='')
			        {
			           candi.get(i).focus();
			           alert("采购清单,第"+(i+1)+"行 产地不能为空");
			           return false;
			        }
			        if($.trim(shuliang.get(i).value)=='')
			        {
			           shuliang.get(i).focus();
			           alert("采购清单,第"+(i+1)+"行 数量不能为空");
			           return false;
			        }
			        if($.trim(danjia.get(i).value)=='')
			        {
			           danjia.get(i).focus();
			           alert("采购清单,第"+(i+1)+"行 单价不能为空");
			           return false;
			        }
			         if($.trim(xiaoji.get(i).value)=='')
			        {
			           xiaoji.get(i).focus();
			           alert("采购清单,第"+(i+1)+"行 小计不能为空");
			           return false;
			        }
            
            }
           
      }
   }
  
   
   
   var jhsj = $("input[name$='jhsj']");
   var jhdd = $("input[name$='jhdd']");
   var jflxr = $("input[name$='jflxr']");
   var lxdh = $("input[name$='lxdh']");
   var bz = $("input[name$='bz']");
   for(i=0;i<jhsj.size();i++){
   
      if(i==0){
            
            
	        if($.trim(jhsj.get(i).value)=='')
	        {
	           jhsj.get(i).focus();
	           alert("交货明细,第"+(i+1)+"行 交货时间 不能为空");
	           return false;
	        }
	        if($.trim(jhdd.get(i).value)=='')
	        {
	           jhdd.get(i).focus();
	           alert("交货明细,第"+(i+1)+"行 交货地点不能为空");
	           return false;
	        }
	        if($.trim(jflxr.get(i).value)=='')
	        {
	           jflxr.get(i).focus();
	           alert("交货明细,第"+(i+1)+"行 甲方联系人不能为空");
	           return false;
	        }
	        if($.trim(lxdh.get(i).value)=='')
	        {
	           lxdh.get(i).focus();
	           alert("交货明细,第"+(i+1)+"行 联系电话不能为空");
	           return false;
	        }
      }
      else
      {
            if($.trim(jhsj.get(i).value)!='' || $.trim(jhdd.get(i).value)!='' || $.trim(jflxr.get(i).value)!='' || 
            $.trim(lxdh.get(i).value)!='' || $.trim(bz.get(i).value)!='')
            {
                    if($.trim(jhsj.get(i).value)=='')
			        {
			           jhsj.get(i).focus();
			           alert("交货明细,第"+(i+1)+"行 交货时间 不能为空");
			           return false;
			        }
			        if($.trim(jhdd.get(i).value)=='')
			        {
			           jhdd.get(i).focus();
			           alert("交货明细,第"+(i+1)+"行 交货地点不能为空");
			           return false;
			        }
			        if($.trim(jflxr.get(i).value)=='')
			        {
			           jflxr.get(i).focus();
			           alert("交货明细,第"+(i+1)+"行 甲方联系人不能为空");
			           return false;
			        }
			        if($.trim(lxdh.get(i).value)=='')
			        {
			           lxdh.get(i).focus();
			           alert("交货明细,第"+(i+1)+"行 联系电话不能为空");
			           return false;
			        }
            
            }
           
      }
      
   }
   var m=0,n=0;
   proname.each(function(i){
       if($(this).val()!='')
       {
         m++;
       }
   })
   jhsj.each(function(i){
       if($(this).val()!='')
       {
         n++;
       }
   })
   if(m!=n)
   {
     alert("采购清单 批次 和 交货明细 批次 需匹配");
     return false;
   }
   
    //开户（支）行名称
   var kfhmc = $('#kfhmc');
   if($.trim(kfhmc.val())=='')
   {
       kfhmc.focus();
       alert('开户（支）行名称不能为空');
       return false;
   }
    
    //账户名称
    var zhmc = $('#zhmc');
   if($.trim(zhmc.val())=='')
   {
       zhmc.focus();
       alert('账户名称不能为空');
       return false;
   }
    
    //账号
    var zh = $('#zh');
    if($.trim(zh.val())=='')
   {
       zh.focus();
       alert('账号不能为空');
       return false;
   }
     
   
   
   return true;
}
</script>

<form id="fm0" method="post">
	<div id="content">
	    <p align="right" style="padding-right: 20px;">
	    <input type="hidden" name="agreement.type" value="${type}">
	    <input type="hidden" name="agreement.code" value="<s:property value="agreement.code"/>">
	    标题<input type="text" name="agreement.title" id="hetitle" style="width:120px;border:0; border-bottom: 1px solid #000;">
	    编号<input type="text" name="agreement.no" id="heno" style="width:120px;border:0; border-bottom: 1px solid #000;">
	    生效时间<input type="text" id="sxsj" name="agreement.sxsj" style="width:100px;border:0; border-bottom: 1px solid #000;"  onclick="WdatePicker();">
	    </p>
		<p align="center"><strong><font  color="#000000" size="+2">采购合同</font></strong></p>
    	    <p><strong>甲方（买方）：<input type="text" name="jiafangtext" id="jiafangtext" style="width:200px;border:0; border-bottom: 1px solid #000 "></strong></p>
    	    <input type="hidden" name="agreement.coopid" value="0"><input type="hidden" name="agreement.jiafang" value="0">
    	    <p><strong>乙方（卖方）：<input type="text" name="yifang" id="yifang"  style="width:200px;border:0; border-bottom: 1px solid #000 "></strong></p>
    	     
    	    <p>经甲乙双方协商后，甲方向乙方订购以下商品，经双方的协商订制本合同，明确双方的权利和义务，以便甲乙双方共同遵守；  <p>
    	    <strong>1、采购清单</strong><br>  
    	    <table width="90%" id="mytab" border="1" class="t1">
				<tr>
					<td style="width:25px">批次</td>
					<td>品名</td>
					<td>规格</td>
					<td>产地</td>
					<td>数量kg</td>
					<td>单价￥</td>
					<td>小计￥</td>
				</tr>
			</table>
			 <strong>2、产品约束</strong><br>  
    	    <p>·     2．1　乙方必须按甲方指定的商品品名、规格、数量等要求及时供货， 乙方供货不符合要求的，甲方有权立即退货 。</p>
    	    <p>·     2．2　乙方所供商品的卫生、质量及包装等必须符合《中华人民共和国食品法》《中华人民共和国食品安全法》《中华人民共和国食品卫生法》的要求，
    	                   如因食品本身质量问题引起甲方出现食物中毒等食品安全事故，由乙方承担一切法律责任及经济责任。</p>
            <p>·     2．3　乙方有义务向甲方提供甲方所需的有关商品资料，商品生产厂家的营业执照复印件、卫生许可证复印件及商品检测报告等：</p>
            
    	    <p><strong> 3、质量与检验</strong></p>
    	    <p> ·   符合甲方相关产品的质量和标准要求。具体标准，参见对应产品的规格书。</p>
    	    <p><strong>4、交货明细</strong></p>
    	    <p> · 4．1 乙方必须按计划指定的品名、数量送达甲方指定的交货地点。详见下表。</p>
    	     <table width="90%" id="mytab1" border="1" class="t1">
				<tr>
					<td style="width:25px">批次</td>				
					<td>交货时间</td>
					<td>交货地点</td>
					<td>甲方联系人</td>
					<td>联系电话</td>
					<td>备注</td>
				</tr>
			</table> 
			<p> · 4．2 	验收：甲方按国家规定的标准或厂方出厂标准验收，使用确认商品质量，并在验收报告上签章盖章 。</p>
    	    <strong>5、付款方式</strong><br>  
    	    <p> · 5．1  乙方指定汇款账户 。</p>
    	     <table width="60%" id="mytab2" border="1" class="t1">
				<tr>
					<td>开户（支）行名称</td> 
					<td><input type="text" name="agreement.ext.kfhmc" id="kfhmc" style="width:100%;border:0;"></td>
				</tr>
				<tr>
					<td>账户名称</td>
					<td><input type="text" name="agreement.ext.zhmc" id="zhmc" style="width:100%;border:0;"></td>
				</tr>
				<tr>
					<td>账号</td>
					<td><input type="text" name="agreement.ext.zh" id="zh" style="width:100%;border:0;"></td>
				</tr>
			</table> 
    	    
			<p> · 5．2  乙方提交合同、验收报告、发票复印件（加盖采购单位公章） 。</p>
			<p> · 5．3 经甲、乙双方协商，具体付款金额和时间如下 。</p>
    	     <table width="90%" id="mytab3" border="1" class="t1">
    	        <tr>
					<td>序号</td>
					<td>款项</td>
					<td>合同总额%</td>
					<td>金额</td>
					<td>支付时间</td>
				</tr>
				<tr>
					<td>1</td>
					<td>订金</td> 
					<td><input type="text" name="agreement.ext.djze" id="djze" style="width:80%;border:0;text-align: right;">%</td>
					<td><input type="text" name="agreement.ext.djje" id="djje" style="width:100%;border:0;text-align: right;"></td>
					<td><input type="text" name="agreement.ext.djsj"  id="djsj" style="width:100%;border:0;" onclick="WdatePicker();" ></td>
				</tr>
				<tr>
					<td>2</td>
					<td>预付款</td> 
					<td><input type="text" name="agreement.ext.yfkze" id="yfkze" style="width:80%;border:0;text-align: right;">%</td>
					<td><input type="text" name="agreement.ext.yfkje" id="yfkje" style="width:100%;border:0;text-align: right;"></td>
					<td><input type="text" name="agreement.ext.yfksj"  id="yfksj" style="width:100%;border:0;" onclick="WdatePicker();" ></td>
				</tr>
				<tr>
					<td>3</td>
					<td>验收完成货款</td>
					<td><input type="text" name="agreement.ext.wckkze" id="wckkze" style="width:80%;border:0;text-align: right;">%</td>
					<td><input type="text" name="agreement.ext.wckje" id="wckje" style="width:100%;border:0;text-align: right;"></td>
					<td><input type="text" name="agreement.ext.wcksj"  id="wcksj" style="width:100%;border:0;" onclick="WdatePicker();" ></td>
				</tr>
				<tr>
					<td>4</td>
					<td>质量保证余款</td> 
					<td><input type="text" name="agreement.ext.yeze" id="yeze" style="width:80%;border:0;text-align: right;">%</td>
					<td><input type="text" name="agreement.ext.yeje" id="yeje" style="width:100%;border:0;text-align: right;"></td>
					<td><input type="text" name="agreement.ext.yesj"  id="yesj" style="width:100%;border:0;" onclick="WdatePicker();" ></td>
				</tr>
			</table> 
    	     <strong>6、违约责任</strong><br>  
    	     <p> · 6．1 甲方无正当理由拒收商品、拒付货款的，向乙方赔付货款总值的<input type="text" name="agreement.ext.bfb1" id="bfb1" style="width:30px;border:0; border-bottom: 1px solid #000;text-align: right; ">%（百分比）违约金。</p>
    	     <p> · 6．2 未经协商，甲方逾期支付设备款的，向乙方赔付欠款<input type="text" name="agreement.ext.bfb2" id="bfb2" style="width:30px;border:0; border-bottom: 1px solid #000;text-align: right; ">%（百分比）。</p>
    	     <p> · 6．3 乙方所交的商品品种、型号、规格不符合合同规定的，甲方有权拒收商品，乙方赔付货款总值<input type="text" name="agreement.ext.bfb3" id="bfb3" style="width:30px;border:0; border-bottom: 1px solid #000;text-align: right; ">%（百分比）的违约金。</p>
    	     <p> · 6．4 乙方不能交付商品的，向甲方赔付货款总值<input type="text" name="agreement.ext.bfb4" id="bfb4" style="width:30px;border:0; border-bottom: 1px solid #000;text-align: right; ">%（百分比）的违约金。</p>
    	     <p> · 6．5 乙方逾期交付商品，向甲方赔付逾期交货部分货款总额的<input type="text" name="agreement.ext.bfb5" id="bfb5" style="width:30px;border:0; border-bottom: 1px solid #000;text-align: right;">%（百分比）。逾期交付超过十天，甲方有权终止合同。</p>
    	     
    	     <strong>7、争议及仲裁</strong><br>  
    	      <p> · 7．1 因商品的质量问题发生争议，由南京市质量监督局或其指定的质量鉴定单位进行质量鉴定。商品符合质量标准的，鉴定费由甲方承担；商品不符合质量标准的，鉴定费由乙方承担。</p>
    	      <p> · 7．2 因本合同引起的争议，双方应协商解决，也可以向合同签订所在地人民法院提出诉讼。</p>
    	     
    	     <strong>8、合同备案</strong><br>  
    	      <p> · 本合同一式两份，由甲乙双方各持一份，该合同经双方当事人签章盖章后生效。</p>
    	      
    	     <table width="80%" id="mytab4" border="0"  style="padding-left: 50px;">
				<tr style="height: 30px;">
					<td width="60">甲方</td>
					<td style="padding-left: 40px;">签章</td>
					<td width="60">乙方</td>
					<td style="padding-left: 40px;">签章</td>
				</tr>
				<tr style="height: 30px;">
					<td>地址</td>
					<td><input type="text" name="jiadizhi" id="agreement.ext.jiadizhi" style="width:180px;border:0; border-bottom: 1px solid #000;"></td>
					<td>地址</td>
					<td><input type="text" name="yidizhi" id="agreement.ext.yidizhi" style="width:180px;border:0; border-bottom: 1px solid #000;"></td>
				</tr>
				<tr style="height: 30px;">
					<td>法人代表</td>
					<td><input type="text" id="jiafrdb" name="agreement.ext.jiafrdb" style="width:180px;border:0; border-bottom: 1px solid #000;">签章</td>
					<td>法人代表</td>
					<td><input type="text" id="yifrdb" name="agreement.ext.yifrdb" style="width:180px;border:0; border-bottom: 1px solid #000;">签章</td>
				</tr>
				<tr style="height: 30px;">
					<td>委托代理人</td>
					<td><input type="text" id="jiawtdlr" name="agreement.ext.jiawtdlr" style="width:180px;border:0; border-bottom: 1px solid #000;">签章</td>
					<td>委托代理人</td>
					<td><input type="text" id="yiwtdlr" name="agreement.ext.yiwtdlr" style="width:180px;border:0; border-bottom: 1px solid #000;">签章</td>
				</tr>
				<tr style="height: 30px;"> 
					<td>电话</td>
					<td><input type="text" id="jiadianhua" name="agreement.ext.jiadianhua" style="width:180px;border:0; border-bottom: 1px solid #000;"></td>
					<td>电话</td>
					<td><input type="text" id="yidianhua" name="agreement.ext.yidianhua" style="width:180px;border:0; border-bottom: 1px solid #000;"></td>
				</tr>
				<tr style="height: 30px;">
					<td>传真</td>
					<td><input type="text" id="jiachuanzhen" name="agreement.ext.jiachuanzhen" style="width:180px;border:0; border-bottom: 1px solid #000;"></td>
					<td>传真</td>
					<td><input type="text" id="yiachuanzhen" name="agreement.ext.yiachuanzhen" style="width:180px;border:0; border-bottom: 1px solid #000;"></td>
				</tr>
				<tr style="height: 30px;">
					<td>邮政编码</td>
					<td><input type="text" id="jiayoubian" name="agreement.ext.jiayoubian" style="width:180px;border:0; border-bottom: 1px solid #000;"></td>
					<td>邮政编码</td>
					<td><input type="text" id="yiyoubian" name="agreement.ext.yiyoubian" style="width:180px;border:0; border-bottom: 1px solid #000;"></td>
				</tr>
				<tr style="height: 30px;">
					<td>开户银行</td>
					<td><input type="text" id="jiakaifuhang" name="agreement.ext.jiakaifuhang" style="width:180px;border:0; border-bottom: 1px solid #000;"></td>
					<td>开户银行</td>
					<td><input type="text" id="yikaifuhang" name="agreement.ext.yikaifuhang" style="width:180px;border:0; border-bottom: 1px solid #000;"></td>
				</tr>
				<tr style="height: 30px;">
					<td>帐号</td>
					<td><input type="text" id="jiazhanghao" name="agreement.ext.jiazhanghao" style="width:180px;border:0; border-bottom: 1px solid #000;"></td>
					<td>帐号</td>
					<td><input type="text" id="yizhanghong" name="agreement.ext.yizhanghong" style="width:180px;border:0; border-bottom: 1px solid #000;"></td>
				</tr>
				<tr style="height: 30px;">
					<td></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</td>
					<td></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</td>
				</tr>
			</table> 
           </div>   
</form>
