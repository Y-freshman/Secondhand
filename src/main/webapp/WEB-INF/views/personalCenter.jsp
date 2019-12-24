<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<link rel="shortcut icon" href="/home/img/icon_3.png" type="image/png" />
<link rel="stylesheet" href="/home/css/element.css">
<link rel="stylesheet" href="/home/css/fonts/element-icons.woff">
<link rel="stylesheet" href="/home/css/personalCenter.css">
<link rel="stylesheet" href="/home/css/index.css">
</head>
<body>
	
	<%@include file="/inc/header2.inc"%>
	
	<div id="personalCenter" style="background: linear-gradient(to bottom, #fff , #eee);">
		<el-container>
			<el-aside >
			<el-row class="tac">
				  <el-col :span="12">
				    <el-menu
				      default-active="2"
				      class="el-menu-vertical-demo"
				      @open="handleOpen"
				      @close="handleClose">
					      <el-submenu index="1">
					        <template slot="title">
					          <i class="el-icon-setting"></i>
					          <span>我的账号</span>
					        </template>
					          <a href="/home/selfInfo.do"><el-menu-item index="1-1">个人中心</el-menu-item></a>
					          <el-menu-item index="1-2" @click="dialogVisible5 = true">会员充值</el-menu-item>
					          	<el-dialog
									  title="会员充值"
									  :visible.sync="dialogVisible5"
									  width="40%"
									  :before-close="handleClose5">
									   <img src="img/erweima.jpg"  style="width: 200px;display: block;margin: 0 auto;"/>
									  <span slot="footer" class="dialog-footer">
									    <el-button @click="dialogVisible5 = false">取 消</el-button>
									    <el-button type="primary" @click="vip()">确 定</el-button>
									  </span>
									</el-dialog>
					          <el-menu-item index="1-3" @click="logout()">退出登录</el-menu-item>
					          <el-menu-item index="1-4" @click="logoutOnce()">切换账号</el-menu-item>
					      </el-submenu>
				          <el-submenu index="2">
					        <template slot="title"><i class="el-icon-menu"></i>我的订单</template>
					          <a href="/home/orderForm.do"><el-menu-item index="2-1"><i class="el-icon-bank-card"></i>待付款</el-menu-item></a>
					          <a href="/home/orderForm.do"><el-menu-item index="2-2"><i class="el-icon-takeaway-box"></i>代发货</el-menu-item></a>
					          <a href="/home/orderForm.do"><el-menu-item index="2-3"><i class="el-icon-truck"></i>代收货</el-menu-item></a>
					          <a href="/home/orderForm.do"><el-menu-item index="2-4"><i class="el-icon-s-claim"></i>已完成</el-menu-item></a>
					      </el-submenu>
					 <a href="/home/fabuqiugou.do">
				      <el-menu-item index="3">
				        <i class="el-icon-edit-outline"></i>
				        <span slot="title">商品求购</span>
				      </el-menu-item>
				     </a> 
				     <a href="/home/publishGoods.do">
				       <el-menu-item index="4">
				        <i class="el-icon-circle-plus-outline"></i>
				        <span slot="title">发布商品</span>
				      </el-menu-item>
				     </a>
				       <el-menu-item index="5" @click="liuyan()" >
				        <i class="el-icon-chat-dot-round"></i>
				        <span slot="title" >我的留言</span>
				      </el-menu-item>
				      <a href="/home/myqiugou.do">
				      <el-menu-item index="7">
				        <i class="el-icon-notebook-2"></i>
				        <span slot="title">我的求购</span>
				      </el-menu-item>
				     </a> 
				     <a href="/home/mygoods.do">
				       <el-menu-item index="8">
				        <i class="el-icon-sold-out"></i>
				        <span slot="title">我的商品</span>
				      </el-menu-item>
				     </a>
				      <!--   <el-menu-item index="5">
				        <i class="el-icon-star-off"></i>
				        <span slot="title">我的收藏</span>
				      </el-menu-item> -->
				      <el-submenu index="6">
					        <template slot="title"><i class="el-icon-question"></i>常见问题</template>
					          <el-menu-item index="6-1" @click="dialogVisible4 = true">交易条款</el-menu-item>
						           	<el-dialog
									  title="交易条款"
									  :visible.sync="dialogVisible4"
									  width="50%"
									  :before-close="handleClose4">
									  <span>客户在接受商品订购与送货的同时，有义务遵守以下交易条款。您在校园淘下订单之前或接受校园淘送货之前，请您仔细阅读以下条款：
											
											<br>1. 订购的商品价格以您下订单时校园淘网上价格为准。
											<br>
											<br>2. 请清楚准确地填写您的真实姓名、送货地址及联系方式。因如下情况造成订单延迟或无法配送等，校园淘将不承担责任：
											<br>
											<br>&emsp;&emsp;&emsp;&emsp;A. 客户提供错误信息和不详细的地址； 
											<br>
											<br>&emsp;&emsp;&emsp;&emsp;B. 货物送达无人签收，由此造成的重复配送所产生的费用及相关的后果； 
											<br>
											<br>&emsp;&emsp;&emsp;&emsp;C. 不可抗力，例如：自然灾害、交通戒严、突发战争等。 
											<br>
											<br>3. 安全性：无论您是电话订购商品或是网络订购商品，我们会保证交易信息的安全，并由校园淘授权的员工处理您的订单。 
											<br>
											<br>4. 隐私权：校园淘尊重您的隐私权，在任何情况下，我们都不会将您的个人和订单信息出售或泄露给任何第三方（国家司法机关调取除外）。我们从网站上或电话中得到的所有客户信息仅用来处理您的相关订单。 
											<br>
											<br>5. 免责：如因不可抗力或其它校园淘无法控制的原因使校园淘销售系统崩溃或无法正常使用导致网上交易无法完成或丢失有关的信息、记录等，校园淘会尽可能合理地协助处理善后事宜，并努力使客户免受经济损失。 
											<br>
											<br>6. 客户监督：校园淘希望通过不懈努力，为客户提供最佳服务，校园淘在给客户提供服务的全过程中接受客户的监督。 
											<br>
											<br>7. 争议处理：如果客户与校园淘之间发生任何争议，可依据当时双方所认定的协议及相关法律进行解决。</span>
									  <span slot="footer" class="dialog-footer">
									    <el-button @click="dialogVisible4 = false">取 消</el-button>
									    <el-button type="primary" @click="dialogVisible4 = false">确 定</el-button>
									  </span>
									</el-dialog>
					          <el-menu-item index="6-2" @click="dialogVisible1 = true">隐私政策</el-menu-item>
					          			<el-dialog
									  title="隐私政策"
									  :visible.sync="dialogVisible1"
									  width="50%"
									  :before-close="handleClose1">
									  <span>校园淘（“我们”）非常重视用户的隐私和个人信息保护。您在使用我们的产品与/或服务时，我们可能会收集和使用您的相关信息。我们希望通过《校园淘隐私政策》（“本隐私政策”）向您说明我们在您使用我们的产品与/或服务时如何收集、使用、保存、共享和转让这些信息，以及我们为您提供的访问、更新、删除和保护这些信息的方式。
											
											本隐私政策将帮助您了解以下内容：
											
											<br>&emsp;&emsp;一、我们如何收集和使用您的个人信息
											<br>
											<br>&emsp;&emsp;二、我们如何使用 Cookies 和同类技术
											<br>
											<br>&emsp;&emsp;三、我们如何共享、转让、公开披露您的个人信息
											<br>
											<br>&emsp;&emsp;四、我们如何保护和保存您的个人信息
											<br>
											<br>&emsp;&emsp;五、您如何管理个人信息
											<br>
											<br>&emsp;&emsp;六、未成年人的个人信息保护
											<br>
											<br>&emsp;&emsp;七、通知和修订
											<br>
											<br>&emsp;&emsp;八、如何联系我们</span>
									  <span slot="footer" class="dialog-footer">
									    <el-button @click="dialogVisible1 = false">取 消</el-button>
									    <el-button type="primary" @click="dialogVisible1 = false">确 定</el-button>
									  </span>
									</el-dialog>
									
					          <el-menu-item index="6-3" @click="dialogVisible2 = true">担保承诺</el-menu-item> 
					          			<el-dialog
									  title="校园淘承诺"
									  :visible.sync="dialogVisible2"
									  width="50%"
									  :before-close="handleClose2">
									  <span>校园淘承诺：
											<br>1. 我们秉承质优价低、放心满意的销售理念为您服务。我们所出售的商品均为正品行货，与您亲临商场选购的商品一样享受相同的质量保证；含有质量保证书的商品按照保证书的承诺执行，其它商品按国家有关规定执行。 
											<br>
											<br>2. 我们承诺在运输“保价费”上永久免费，在配送环节上承担保险费用，运输过程的风险一律由校园淘承担，客户收到货物如果有损坏、遗失等情形，只要当场提出声明，并进行相关举证，校园淘将按照正常售后退换货程序予以先行处理。 
											<br>
											<br>3. 我们承诺通过我司提供的网上支付平台支付，为客户承担全额手续费，但由于客户原因取消正常状态下的订单要求款项返还时（做校园淘帐户余额除外），则由客户承担相关手续费；货物打包不收取任何包装费。</span>
									  <span slot="footer" class="dialog-footer">
									    <el-button @click="dialogVisible2 = false">取 消</el-button>
									    <el-button type="primary" @click="dialogVisible2 = false">确 定</el-button>
									  </span>
									</el-dialog>
					          
					          <el-menu-item index="6-4" @click="dialogVisible3 = true">会员介绍</el-menu-item> 
					          			<el-dialog
									  title="会员介绍"
									  :visible.sync="dialogVisible3"
									  width="50%"
									  :before-close="handleClose3">
									  <span>我司针对会员用户的购买是有优惠政策的，一般只针对批量购买同一款产品的情况，同时要看所订购的产品当时的销售模式，如果是正在促销的产品，是无法再进行优惠的。除此之外，针对会员用户，我司将上线专属于会员用户的频道，并会不定时举行针对会员用户的促销专场（如：会员采购节）。</span>
									  <span slot="footer" class="dialog-footer">
									    <el-button @click="dialogVisible3 = false">取 消</el-button>
									    <el-button type="primary" @click="dialogVisible3 = false">确 定</el-button>
									  </span>
									</el-dialog>
					  </el-submenu>
				    </el-menu>
				  </el-col>
				  </el-row>
			</el-aside>
			
			<el-main>
				<div class="toux_top">
					<el-row>
						 <el-col :span="24">
					  			<el-avatar :src="Avater" style="box-shadow: 1px 2px 5px #333;margin-top:20px;"></el-avatar>
						  		<div >
						  			<el-image v-if="vips == '1'" src="img/vip_2.jpg"  style="width:15px;height:15px;box-shadow: 1px 2px 4px #673AB7;margin-left: 25px;margin-top: -15px;" lazy></el-image>
						  		</div>
						  		<div style="text-align: center;">
					  			<span style="color: #333;font-size: 16px;font-weight:bold;margin-left: 6px;">{{userName}}</span>
					  				<i v-if="sex == '0' " class="el-icon-male" style="color: #409eff;font-size: 13px;"></i>
			  						<i v-if="sex == '1' " class="el-icon-female" style="color: #F44336;font-size: 13px;"></i>
					  			</div>
						</el-col> 
					</el-row>
			   </div>
			
				<div class="tx">
					<el-row style="margin-top: 10px;">
						
						<el-col :span="6">
							 <el-link :underline="false"  href="/home/orderForm.do" >
								 <i class="el-icon-bank-card"></i>
								 <br>待付款
							</el-link>
						</el-col>
						<el-col :span="6">
							<el-link :underline="false"  href="/home/orderForm.do" >
								<i class="el-icon-takeaway-box"></i>
								<br>代发货 
							</el-link>
						</el-col> 
						<el-col :span="6">
							<el-link :underline="false"  href="/home/orderForm.do" >
								<i class="el-icon-truck"></i>
								<br>代收货
							</el-link>
						</el-col>  
						<el-col :span="6">
							<el-link :underline="false"  href="/home/orderForm.do" >
								<i class="el-icon-s-claim"></i>
								<br>已完成
							</el-link>
						</el-col>  
					</el-row>
			   </div>
			   
				<div class="like">
					<div class="like1">
							<span class="like2">
								猜你喜欢
							</span>
							<el-button icon="el-icon-refresh" class="huan_button" @click="change()">换一组</el-button>
					</div>
					
				<el-row :gutter="20" >
			  		<el-col :span="24" >
			  		</el-col>
				</el-row>
				
				<el-row :gutter="20" v-if="maylike1.length>1" >
		  		<el-col :span="8" v-for="(item,index) in maylike1" v-bind:key="item.goodsId">
			  		<el-card style="margin-bottom:20px;margin-left:20px;">
					  	<div style="float: left;height: 200px">
					  		<div >
					  			<el-image :src="item.goodsPics[0]"  fit="contain" style="height:130px;" lazy></el-image>
					  		</div>
					  		<div style="margin-top: 10px;height:70px;">
					  			<div style="height: 40px;overflow: hidden;margin-bottom: 5px;">
					  				<el-link class="truncate2" @click="toGoods(item.goodsId)">{{item.goodsName}}</el-link>
					  			</div>
					  			<div><b style="color: #673AB7;float: left;">￥{{item.goodsNewPrice}}.00</b>
					  			<span style="color: #999;font-size: 13px;float: right;margin-top: 5px;margin-left: -5px">
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			</div>	
			</el-main>
		</el-container>
		<%@include file="/inc/footer.inc"%>
	</div>
</body>
<script src="/home/js/vue.js"></script>
<script src="/home/js/element.js"></script>
<script src="/home/js/jquery.min.js"></script>
<script src="/home/js/personalCenter.js"></script>
<script src="/home/js/header.js"></script>
</html>