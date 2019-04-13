//获取所有项目列表
	function initCategory() {

		var selObj = $("#categoryId");
		$("#categoryId option").remove();
		selObj.append("<option value='0'>全部</option>");
		$.ajax({
			type : "get",
			url : "/data/categories",
			data : {

			},
			async : false,
			success : function(text) {
				/*<![CDATA[*/
				for (var i = 0; i < text.length; i++) {
					var index = text[i];
					selObj.append("<option value='"+index.id+"'>" + index.cataname
							+ "</option>");
				}
				/*]]>*/
			}
		})
	}

	
	function initCategory2(father) {

		var selObj = $("#category2Id");
		$("#category2Id option").remove();
		selObj.append("<option value='0'>全部</option>");
		$.ajax({
			type : "get",
			url : "/data/categories",
			data : {
				father:father
			},
			async : false,
			success : function(text) {
				/*<![CDATA[*/
				for (var i = 0; i < text.length; i++) {
					var index = text[i];
					selObj.append("<option value='"+index.id+"'>" + index.cataname
							+ "</option>");
				}
				/*]]>*/
			}
		})
	}
	
	
	//获取所有项目列表
	function initDepartment() {

		var selObj = $("#departmentId");
		$("#departmentId option").remove();
		selObj.append("<option value='0'>全部</option>");
		$.ajax({
			type : "get",
			url : "/data/departments",
			data : {

			},
			async : false,
			success : function(text) {
				/*<![CDATA[*/
				for (var i = 0; i < text.length; i++) {
					var index = text[i];
					selObj.append("<option value='"+index.id+"'>" + index.shortName
							+ "</option>");
				}
				/*]]>*/
			}
		})
	}
	
	
	function initItem() {

		var selObj = $("#itemId");
		$("#itemId option").remove();
		selObj.append("<option value='0'>全部</option>");
		$.ajax({
			type : "get",
			url : "/data/items",
			data : {

			},
			async : false,
			success : function(text) {
				/*<![CDATA[*/
				for (var i = 0; i < text.length; i++) {
					var index = text[i];
					selObj.append("<option value='"+index.id+"'>" + index.name
							+ "</option>");
				}
				/*]]>*/
			}
		})
	}
	
	