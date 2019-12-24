<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
<title>商品发布</title>
<link rel="shortcut icon" href="/home/img/icon_3.png" type="image/png" />
<link rel="stylesheet" href="/home/css/element.css">
<link rel="stylesheet" href="/home/css/index.css">
<link rel="stylesheet" href="/home/css/publishGoods.css">
</head>
<body>
	<div id="publishGoods">
		<el-container>
		  <el-main style="background: linear-gradient(to bottom, #fff , #eee);min-height:400px;padding-top: 0px;">
		  	<el-row :gutter="20" >
		  	  <el-col :span="8">
	  			<el-image src="img/icon_1.png" class="shouye_tubiao"  lazy></el-image>
	  			<span class="shouye_tubiao2" >
	  				校园二手淘<br>www.hcljy.com
	  			</span>
			  </el-col>
			  <el-col :span="8" style="text-align:center;float: left;margin-top: 35px;">
			  	<span class="fbqg_bt">商品发布</span>
			  </el-col>
		  	  <el-col :span="8"  style="float: right;margin-top: 10px;">
			  	<div style="float: right;">
			  		<div style="float: left;">
			  			<el-avatar :src="Avater" style="box-shadow: 1px 2px 5px #333"></el-avatar>
			  		</div>
			  		<div style="float: left;width:15px;height:15px;margin-top: 25px;margin-left: -15px">
			  			<el-image v-if="vip == '1' " src="img/vip_2.jpg"  style="width:15px;height:15px;box-shadow: 1px 2px 4px #673AB7" lazy></el-image>
			  		</div>
			  		<div style="float: left;margin-top: 45px;margin-left: -55px;width:75px;text-align: center;">
			  			<span style="color: #666;font-size: 13px;font-weight: 600">{{userName}}</span>
			  			<i v-if="sex == '0' " class="el-icon-male" style="color: #409eff;font-size: 13px;"></i>
			  			<i v-if="sex == '1' " class="el-icon-female" style="color: #F44336;font-size: 13px;"></i>
			  		</div>
		  		</div>
			  </el-col>
			</el-row>
		  	
		  	<el-card class="box-card">
		      <h3 style="text-align:center;">商品介绍</h3>
		      
		        <el-form ref="goods" :rules="rules" :model="goods" label-width="150px">
			        <el-form-item label="商品名称" prop="name">
			          <el-input v-model="goods.name" clearable/>
			        </el-form-item>
			        <el-form-item label="专柜价格" prop="counterPrice">
			          <el-input v-model="goods.counterPrice" placeholder="0.00" clearable>
			            <template slot="append">元</template>
			          </el-input>
			        </el-form-item>
			         <el-form-item label="现售价格" prop="retailPrice">
				          <el-input v-model="goods.retailPrice" placeholder="0.00" clearable>
				            <template slot="append">元</template>
				          </el-input>
					  </el-form-item>
					 <el-form-item label="是否新品" >
				         <template >
							  <el-select v-model="goods.options.value" placeholder="请选择商品折旧程度" style="width:100%" >
							    <el-option
							      v-for="item in goods.options"
							      :key="item.value"
							      :label="item.label"
							      :value="item.value">
							    </el-option>
							  </el-select>
						</template>	
				      </el-form-item>
					    <el-form-item label="商品类别" >
					         <template >
								  <el-select v-model="goods.optionsOnce.value" placeholder="请选择商品类别" style="width:100%" >
								    <el-option
								      v-for="item in goods.optionsOnce"
								      :key="item.value"
								      :label="item.label"
								      :value="item.value">
								    </el-option>
								  </el-select>
							</template>	
					      </el-form-item>
					 <el-form-item label="商品上传" >
				         	<el-upload
						   	  ref='upload'
							  action="http://upload-z0.qiniup.com"
							  :data="tk"
							  list-type="picture-card"
							  accept="image/*"
							  :limit="imgLimit"
							  :file-list="productImgs"
							  :multiple="isMultiple"
							  :on-preview="handlePictureCardPreview"
							  :on-remove="handleRemove"
							  :on-success="handleAvatarSuccess"
							  :before-upload="beforeAvatarUpload"
							  :on-exceed="handleExceed"
							  :on-error="imgUploadError"
							  >
							  <i  class="el-icon-plus" style="line-height: 140px;"></i>
							</el-upload>
							<el-dialog :visible.sync="dialogVisible">
							  <img width="100%" :src="dialogImageUrl" alt="">
							</el-dialog>
				      </el-form-item>
				   
				   <el-form-item label="商品数量" prop="num">
				        <template>
						  <el-input-number style="line-height:0px;" v-model="goods.num" :min="1" :max="10" label="描述文字"></el-input-number>
						</template>
				     </el-form-item>
				    
				     <el-form-item label="卖家姓名" prop="sealname">
				          <el-input v-model="goods.sealname" placeholder="请输入卖家姓名" clearable>
				          </el-input>
				    </el-form-item>
				    
				     <el-form-item label="卖家号码" prop="phone">
				          <el-input v-model="goods.phone" placeholder="请输入卖家电话号码" clearable>
				          </el-input>
				    </el-form-item>
				   
				   <el-form-item>
					    <el-button type="primary" @click="submitForm('goods')">发布</el-button>
					    <el-button @click="resetForm('goods')">重置</el-button>
					  </el-form-item>
		        </el-form>
				      
		       		<!-- <el-form :model="goods" :rules="rules" ref="goods.name" label-width="100px" class="demo-ruleForm">
					  	<el-form-item label="商品名称" prop="goods.name">
					    <el-input type="text" v-model="goods.name"></el-input>
				  	</el-form-item>
				  	<el-form-item label="专柜价格" prop="goods.counterPrice">
			          <el-input v-model="goods.counterPrice" placeholder="0.00">
			            <template slot="append">元</template>
			          </el-input>
			        </el-form-item>
				 	 <el-form-item label="现售价格" prop="goods.retailPrice">
				          <el-input v-model="goods.retailPrice" placeholder="0.00">
				            <template slot="append">元</template>
				          </el-input>
				      </el-form-item>
				      <el-form-item label="是否新品" >
				          <template >
							  <el-select v-model="goods.options.value" placeholder="请选择商品折旧程度" style="width:100%" >
							    <el-option
							      v-for="item in goods.options"
							      :key="item.value"
							      :label="item.label"
							      :value="item.value">
							    </el-option>
							  </el-select>
						</template>	
				       </el-form-item>
				     
					  
					  <el-row :gutter="20" >
						  <el-col :span="22" :offset="1" >
						   	<el-upload
						   	  ref='upload'
							  action="http://qiniup.com"
							  :data="tk"
							  list-type="picture-card"
							  accept="image/*"
							  :limit="imgLimit"
							  :file-list="productImgs"
							  :multiple="isMultiple"
							  :on-preview="handlePictureCardPreview"
							  :on-remove="handleRemove"
							  :on-success="handleAvatarSuccess"
							  :before-upload="beforeAvatarUpload"
							  :on-exceed="handleExceed"
							  :on-error="imgUploadError"
							  >
							  <i class="el-icon-plus"></i>
							</el-upload>
							<el-dialog :visible.sync="dialogVisible">
							  <img width="100%" :src="dialogImageUrl" alt="">
							</el-dialog>
					  </el-col>
					</el-row>
					
					<el-form-item label="商品数量" >
				        <template>
						  <el-input-number style="line-height:0px;" v-model="goods.num" :min="1" :max="10" label="描述文字"></el-input-number>
						</template>
				      </el-form-item>
				      
				    <el-form-item label="商品详情" prop="goods.detail">
				          <el-input v-model="goods.detail" placeholder="请输入商品详情">
				          </el-input>
				    </el-form-item>
					  <el-form-item>
					    <el-button type="primary" @click="submitForm('goods')">发布</el-button>
					    <el-button @click="resetForm('goods')">重置</el-button>
					  </el-form-item>
				</el-form> -->
		      	<!-- <el-input v-model="goods_name"  placeholder="请输入商品名称"  clearable>
  					 <el-button slot="prepend" icon="el-icon-user-solid"></el-button>
		 		</el-input> -->
		    </el-card>
		  </el-main>
		</el-container>
	<%@include file="/inc/footer.inc"%>
	</div>
</body>
<script src="/home/js/vue.js"></script>
<script src="/home/js/element.js"></script>
<script src="/home/js/jquery.min.js"></script>
<script src="/home/js/publishGoods.js"></script>