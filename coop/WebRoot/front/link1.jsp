<%@page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.net.URLEncoder"%>
<%
Map<String,String> map = new HashMap<String,String>();
map.put("1",URLEncoder.encode("本草品牌","UTF-8"));
map.put("2",URLEncoder.encode("合作公告","UTF-8"));
map.put("3",URLEncoder.encode("支付方式","UTF-8"));
map.put("4",URLEncoder.encode("配送方式","UTF-8"));
map.put("5",URLEncoder.encode("平台资质","UTF-8"));
map.put("6",URLEncoder.encode("工具频道","UTF-8"));
map.put("7",URLEncoder.encode("国际站点","UTF-8"));
map.put("8",URLEncoder.encode("关于我们","UTF-8"));
%>
<!-- ===================================================== MAIN CONTENT[end] -->
						<div class="home_clients">
							<div class="grid_3 hp_item_grid">
								<h1 class="home_module_title">了解更多本草品味</h1>
								<p>了解更多关于渡之珍 本草品味的信息</p>
							</div>
							<div class="grid_9">
								<div class="hp_item_grid_client">
									<div class="hp_grid_img_client">
										<a href="showmessage.html?title=<%=map.get("1")%>&id=1" target="_blank"><img
											src="front/images/assets/envato-logo/bcwp.png"
											alt="" />
										</a>
									</div>
								</div>
								<div class="hp_item_grid_client">
									<div class="hp_grid_img_client">
										<a href="showmessage.html?title=<%=map.get("2")%>&id=2" target="_blank"><img
											src="front/images/assets/envato-logo/hzgg.png" alt="" />
										</a>
									</div>
								</div>
								<div class="hp_item_grid_client">
									<div class="hp_grid_img_client">
										<a href="showmessage.html?title=<%=map.get("3")%>&id=3" target="_blank"><img
											src="front/images/assets/envato-logo/zffs.png" alt="" />
										</a>
									</div>
								</div>
								<div class="hp_item_grid_client">
									<div class="hp_grid_img_client">
										<a href="showmessage.html?title=<%=map.get("4")%>&id=4" target="_blank"><img
											src="front/images/assets/envato-logo/psfs.png" alt="" />
										</a>
									</div>
								</div>
								<div class="hp_item_grid_client">
									<div class="hp_grid_img_client">
										<a href="showmessage.html?title=<%=map.get("5")%>&id=5" target="_blank"><img
											src="front/images/assets/envato-logo/ptzz.png" alt="" />
										</a>
									</div>
								</div>
								<div class="hp_item_grid_client">
									<div class="hp_grid_img_client">
										<a href="showmessage.html?title=<%=map.get("6")%>&id=6" target="_blank"><img
											src="front/images/assets/envato-logo/gjpd.png"
											alt="" />
										</a>
									</div>
								</div>
								<div class="hp_item_grid_client">
									<div class="hp_grid_img_client">
										<a href="showmessage.html?title=<%=map.get("7")%>&id=7" target="_blank"><img
											src="front/images/assets/envato-logo/gjzd.png" alt="" />
										</a>
									</div>
								</div>
								<div class="hp_item_grid_client">
									<div class="hp_grid_img_client">
										<a href="showmessage.html?title=<%=map.get("8")%>&id=8" target="_blank"><img
											src="front/images/assets/envato-logo/gywm.png" alt="" />
										</a>
									</div>
								</div>
							</div>
							<div class="clear"></div>
						</div>

						<!-- ============= / CLIENTS[end] -->