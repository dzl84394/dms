(function($) {
	'use strict';

	$.pagination = function(el, options) {
		if (!(this instanceof $.pagination)) {
			return new $.pagination(el, options);
		}

		var self = this;

		self.$container = $(el);

		self.$container.data('pagination', self);

		self.init = function() {
			if (options.first || options.prev || options.next || options.last
					|| options.page) {
				options = $.extend({}, {
					first : '',
					prev : '',
					next : '',
					last : '',
					page : ''
				}, options);
			}
			self.options = $.extend({}, $.pagination.defaultOptions, options);

			self.extendJquery();

			self.render();

		};

		self.extendJquery = function() {
			$.fn.paginationHTML = function(s) {
				return s ? this.before(s).remove() : $('<p>').append(
						this.eq(0).clone()).html();
			};
		};

		self.render = function() {
			self.renderHtml();

		};

		self.renderHtml = function() {
			var options = self.options;
			var fenyehtml = "<div class='col-sm-6'><ul class='pagination' id='pagination'>${{lis}}</ul></div><div class='col-sm-offset-5'><label style='margin: 30px;'>共计"
					+ options.totalNumber + "条记录</label></div>";

			var html = '';
			if (options.currentPage == 0) {
				html = "<li class='disabled'><a  href='#'  aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>";
			} else {
				html = "<li><a href=\"javascript:getAll("
						+ (options.currentPage-1)
						+ ")\";  aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>";
			}
			if(options.totalPages<=10){//小于10的，全展示
		        for(var i = 0;i<options.totalPages;i++){
		            if(options.currentPage==i){
		                var link_Url = "<li class='active'><a href=\"javascript:getAll("+(i)+");\">"+(i+1)+"</a></li>";
		            }else
		                var link_Url = "<li><a href=\"javascript:getAll("+(i)+");\">"+(i+1)+"</a></li>";
		            html += link_Url;
		        }
		    }else{
		        if(options.currentPage<5){
		            for(var i = 0;i<options.totalPages;i++){
		                if(i<5){
		                    if(options.currentPage==i){
		                        var link_Url = "<li class='active'><a href=\"javascript:getAll("+(i)+");\">"+(i+1)+"</a></li>";
		                    }else {
		                        var link_Url = "<li><a href=\"javascript:getAll("+(i)+");\">" + (i + 1) + "</a></li>";
		                    }
		                    html += link_Url;
		                }
		            }
		            html += "<li><a>...</a></li>";
		            html += "<li><a href=\"javascript:getAll("+(i)+");\">"+(i)+"</a></li>";
		        }else if(options.currentPage>=5 && options.currentPage<options.totalPages-3){
		            html += "<li><a href=\"javascript:getAll("+(1)+");\">"+1+"</a></li>";
		            html += "<li><a>...</a></li>";
		            for(var i = 0;i<options.totalPages;i++){

		                if(i>=options.currentPage-2 && i <= options.currentPage +0 ){
		                    if(options.currentPage==i){
		                        var link_Url = "<li class='active'><a href=\"javascript:getAll("+(i)+");\">"+(i+1)+"</a></li>";
		                    }else {
		                        var link_Url = "<li><a href=\"javascript:getAll("+(i)+");\">" + (i + 1) + "</a></li>";
		                    }
		                    html += link_Url;
		                }
		            }
		            html += "<li><a>...</a></li>";
		            html += "<li><a href=\"javascript:getAll("+(i)+");\">"+i+"</a></li>";
		        }else{
		            html += "<li><a href=\"javascript:getAll("+1+");\">"+(1)+"</a></li>";
		            html += "<li><a>...</a></li>";
		            for(var i = 0;i<options.totalPages;i++){

		                if(i>=options.totalPages-5){
		                    if(options.currentPage==i){
		                        var link_Url = "<li class='active'><a href=\"javascript:getAll("+(i)+");\">"+(i+1)+"</a></li>";
		                    }else{
		                        var link_Url = "<li><a href=\"javascript:getAll("+(i)+");\">"+(i+1)+"</a></li>";
		                    }
		                    html += link_Url;
		                }
		            }


		        }

		    }
			
			
			   if(options.currentPage==(options.totalPages-1)){
			        html += "<li  class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>";
			    }else{
			        html += "<li><a href=\"javascript:getAll("+(options.currentPage+1)+")\"; aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>";
			    }
			
			 html += "<li style='width: 50px;float: left;margin-left: 10px'><input id='paginationGo'" +
		        " type='text' class='form-control'/></li>" +
		        "<li style='width: 50px;float: left;margin-left: 10px'><a href=\"javascript:getAll(-1);\" text-align:center;>Go</a></li>";
			 
			 
			if (self.options.wrapper) {
				self.$container.html($(self.options.wrapper)
						.html(html.join('')).paginationHTML());
			} else {
				self.$container.html(fenyehtml.replace("${{lis}}",html));
			}
		};

	

		self.isNumber = function(value) {
			var type = typeof value;
			return type === 'number' || type === 'undefined';
		};

		self.isEnable = function(type) {
			return self.options[type] && typeof self.options[type] === 'string';
		};

		


		self.callMethod = function(method, options) {
			switch (method) {
			case 'option':
				self.options = $.extend({}, self.options, options);
				self.verify();
				self.render();
				break;
			case 'destroy':
				self.$container.empty();
				self.$container.removeData('pagination');
				break;
			default:
				throw new Error('[pagination] method "' + method
						+ '" does not exist');
			}

			return self.$container;
		};


		self.init();

		return self.$container;

	}

	$.pagination.defaultOptions = {
		wrapper : '',
		first : '<li class="first"><a href="javascript:;">First</a></li>',
		prev : '<li class="prev"><a href="javascript:;">Previous</a></li>',
		next : '<li class="next"><a href="javascript:;">Next</a></li>',
		last : '<li class="last"><a href="javascript:;">Last</a></li>',
		page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
		totalPages : 0,
		totalCounts : 0,
		totalNumber : 0,
		pageSize : 0,
		currentPage : 1,
		visiblePages : 7,
		disableClass : 'disabled',
		activeClass : 'active'
	};

	$.fn.pagination = function() {
		var self = this, args = Array.prototype.slice.call(arguments);
		if (typeof args[0] === 'string') {

			var $instance = $(self).data('pagination');
			if (!$instance) {
				throw new Error('[pagination] the element is not instantiated');
			} else {
				return $instance.callMethod(args[0], args[1]);
			}
		} else {
			return new $.pagination(this, args[0]);
		}
	};

})(jQuery);
