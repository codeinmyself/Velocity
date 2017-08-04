$(document).ready(function () {
	  var mySwiper = new Swiper ('.swiper-container', {
		direction: 'horizontal',
		loop: true,
		autoplay:3000,
		// 如果需要分页器
		pagination: '.swiper-pagination',
		paginationClickable: true,
		
		// 如果需要滚动条
		scrollbar: '.swiper-scrollbar',
	  })  
});

$(document).ready(function () {
	$("#goods-detail-div").scroll(function()
	{
		var scrollTop=$("#goods-detail-div").scrollTop();
		var uptownTop= -0.133 * scrollTop + 7;
		$("#goods-detail-swiper-pic").css("top",uptownTop+"%");
	});
});

$(document).ready(function(){

	$("#display-all-description-button").click(function(){
		var scrollHeight=document.getElementById("goods-description-content").scrollHeight;
		var height=$("#goods-description-content").height();
		if(scrollHeight>=height)
		{
			$("#goods-description-content").css("height",scrollHeight+"px");
			$("#display-all-description-div").hide();
			$("#hidden-all-description-div").show();
		}
	});

	$("#hidden-all-description-button").click(function(){
		$("#goods-description-content").css("height","30px");
		$("#display-all-description-div").show();
		$("#hidden-all-description-div").hide();
	});
});


function addCollection() 
{
	if(!$("#hiddenSessionUserId")[0])
	{
		var springUrl=$("#hiddenSpringUrl").val();
		var pathname=window.location.pathname;
		pathname=pathname.replace("/JavaEE","");
		var form=$("<form action='"+springUrl+"/login' method='post'></form>")
		var inputHidden=$("<input type='hidden' name='urlPath' value='"+pathname+"'/>");
		form.append(inputHidden);
		form.appendTo("body");
        form.css('display','none');
        form.submit();
	}
	else
	{
		var springUrl = $("#hiddenSpringUrl").val();
		if (document.getElementById("isCollection").src == "http://localhost:8080/JavaEE/resources/images/zjh/goodsDetail-footer-3.png")
		{
			document.getElementById("isCollection").src = "/JavaEE/resources/images/zjh/red_heart.png";
				$.ajax({
					url : springUrl + "/user/collection/add",
					async : false,
					cache : false,
					type : 'post',
					dataType : "json",
					data : {
						goodsId : $("#hiddenGoodsId").val(),
					},
					success : function(data) {
						if (data.code == "200") {
							location.reload();
						}
					}
				});
		}
		else if (document.getElementById("isCollection").src == "http://localhost:8080/JavaEE/resources/images/zjh/red_heart.png") {
			document.getElementById("isCollection").src = "/JavaEE/resources/images/zjh/goodsDetail-footer-3.png";
					$.ajax({
						url : springUrl + "/user/collection/delete",
						async : false,
						cache : false,
						type : 'post',
						dataType : "json",
						data : {
							goodsId : $("#hiddenGoodsId").val(),
						},
						success : function(data) {
							if (data.code == "200") {
								location.reload();
							}
						}
					});
			}
	}
}
function deleteCollection(goodsId) 
{
	var springUrl = $("#hiddenSpringUrl").val();
	$.ajax({
		url : springUrl + "/user/collection/delete",
		async : false,
		cache : false,
		type : 'post',
		dataType : "json",
		data : {
			goodsId : goodsId
		},
		success : function(data) {

		}
	});
	window.location.reload();
}

