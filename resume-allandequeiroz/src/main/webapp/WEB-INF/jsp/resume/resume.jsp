<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="${locale}">
    <head>
        <meta name="viewport" content="<fmt:message key="meta.viewport"/>">
        <meta http-equiv="Content-Type" content="<fmt:message key="meta.content-type"/>" />
        <meta name="author" content="<fmt:message key="meta.author"/>"/>
        <meta name="reply-to" content="<fmt:message key="meta.reply-to"/>"/>

        <meta name="description" content="<fmt:message key="meta.description"/>"/>
        <meta name="keywords" content="<fmt:message key="meta.keywords"/>"/>
        <title><fmt:message key="title"/></title>

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/cv.css" rel="stylesheet">
    </head>
	<body>

		<div class="platform">

            <!--
            <span id="idiomas" style="margin-right: 70px;">
                <c:if test="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']=='pt'}">
                    <a class="idioma" href="<c:url value="/pt"/>" style="margin-right: 5px;"><span class="flag flag-pt" style="margin-right: 5px;"></span><fmt:message key="language-pt"/></a>
                    <a class="idioma" href="<c:url value="/en"/>" style="margin-right: 5px; color: rgb(192, 191, 200);"><span class="flag flag-en not-selected"></span><fmt:message key="language-en"/></a>
                </c:if>
                <c:if test="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']=='en'}">
                    <a class="idioma" href="<c:url value="/pt"/>" style="margin-right: 5px; color: rgb(192, 191, 200);"><span class="flag flag-pt not-selected" style="margin-right: 5px;"></span><fmt:message key="language-pt"/></a>
                    <a class="idioma" href="<c:url value="/en"/>" style="margin-right: 5px;"><span class="flag flag-en"></span><fmt:message key="language-en"/></a>
                </c:if>
            </span>
            -->

			<div class="header">

		    	<div class="row">

                    <!--
		        	<div class="span">
		        		<img src="images/photo2.png" class="img-polaroid">
		        	</div>
		        	-->
		        	<!--/photo-->

		        	<div class="span margin-bottom-5">
		        		<div class="name-text"><fmt:message key="name"/></div>
		        		<div class="major-text"><i><fmt:message key="major"/></i></div>
		        	</div>
		        	<!--/name-->

		        	<div class="span pull-right">
						<div class="span">
                            <!--
							<address class="margin-bottom-5"><fmt:message key="address"/></address>
							-->
							<abbr rel="tooltip" data-original-title="Phone"><fmt:message key="phone-indicator"/></abbr>&nbsp;&nbsp;<fmt:message key="phone"/><br>
							<abbr rel="tooltip" data-original-title="Email"><fmt:message key="email-indicator"/></abbr>&nbsp;&nbsp;<a href="mailto:<fmt:message key="email"/>"><fmt:message key="email"/></a><br>
                            <!--
							<abbr rel="tooltip" data-original-title="Website">W:</abbr>&nbsp;<a href="www.domain.com"><fmt:message key="linkedin"/></a><br>
							-->
							<div class="margin-top-5 margin-bottom-5">
								<a href="<fmt:message key="linkedin"/>" rel="tooltip" data-original-title="LinkedIn"><img src="images/linkedin.png" alt="LinkedIn" width="20"/></a>&nbsp;
								<a href="<fmt:message key="twitter"/>" rel="tooltip" data-original-title="Twitter"><img src="images/twitter.png" alt="Twitter" width="20"/></a>&nbsp;
                                <a href="<fmt:message key="wordpress"/>" rel="tooltip" data-original-title="Blog"><img src="images/wordpress.png" alt="Twitter" width="26"/></a>&nbsp;
							</div>
						</div>
						<div class="span">
							<img src="images/qrcode.png" width="75" height="75" rel="tooltip" data-original-title="<fmt:message key="vcard"/>">
						</div>

						<a class="pdf" href="doc/AllandeQueiroz.pdf" target="_blank" rel="tooltip" data-original-title="<fmt:message key="pdf"/>"></a>


		        	</div>
		        	<!--/contacts-->

		      	</div>

	    	</div><!-- /header -->

	      	
	      	<div class="main">  	

	   			<div class="row">
	        		<div class="span section-title">
                        <fmt:message key="objective"/>
		        	</div>
		        	<div class="span section-body">
                        <fmt:message key="objective-description"/>
		        	</div>
	      		</div>
	      		<!-- /objective-->

      			<div class="seperator"></div>

      			<div class="row">
	      			<div class="span section-title">
                          <fmt:message key="experience"/>
			        </div>
	        		
	        		<div class="span section-body">
		        		
		        		<div class="clearfix">
			        		<div class="row">
				        		<div class="span">
				        			<div class="item-name"><fmt:message key="petrobras"/></div>
				        			<div class="item-desc"><fmt:message key="petrobras-position"/></div>
				        		</div>	
				        		<div class="item-period pull-right span"><fmt:message key="petrobras-period"/></div>
				        	</div>
				        	<div class="margin-top-10">	
				        		<ul>
									<li><fmt:message key="petrobras-pge"/></li>
								</ul>
				        	</div>
				        </div>

				        <div class="inner-seperator"></div>

				        <div class="clearfix">
			        		<div class="row">
				        		<div class="span">
				        			<div class="item-name"><fmt:message key="puc"/></div>
				        			<div class="item-desc"><fmt:message key="puc-position"/></div>
				        		</div>	
				        		<div class="item-period pull-right span"><fmt:message key="puc-period"/></div>
				        	</div>
				        	<div class="margin-top-10">	
				        		<ul>
									<li><fmt:message key="puc-cge"/></li>
									<li><fmt:message key="puc-pesq"/></li>
									<li><fmt:message key="puc-baquara"/></li>
                                    <li><fmt:message key="puc-ponto"/></li>
								</ul>
				        	</div>
				        </div>

                        <div class="inner-seperator"></div>

                        <div class="clearfix">
                            <div class="row">
                                <div class="span">
                                    <div class="item-name"><fmt:message key="deal"/></div>
                                    <div class="item-desc"><fmt:message key="deal-position"/></div>
                                </div>
                                <div class="item-period pull-right span"><fmt:message key="deal-period"/></div>
                            </div>
                            <div class="margin-top-10">
                                <ul>
                                    <li><fmt:message key="deal-bot"/></li>
                                    <li><fmt:message key="deal-misc"/></li>
                                </ul>
                            </div>
                        </div>

                        <div class="inner-seperator"></div>

                        <div class="clearfix">
                            <div class="row">
                                <div class="span">
                                    <div class="item-name"><fmt:message key="expertise"/></div>
                                    <div class="item-desc"><fmt:message key="expertise-position"/></div>
                                </div>
                                <div class="item-period pull-right span"><fmt:message key="expertise-period"/></div>
                            </div>
                            <div class="margin-top-10">
                                <ul>
                                    <li><fmt:message key="expertise-molicar"/></li>
                                    <li><fmt:message key="expertise-misc"/></li>
                                </ul>
                            </div>
                        </div>

                        <div class="inner-seperator"></div>

                        <div class="clearfix">
                            <div class="row">
                                <div class="span">
                                    <div class="item-name"><fmt:message key="click"/></div>
                                    <div class="item-desc"><fmt:message key="click-position"/></div>
                                </div>
                                <div class="item-period pull-right span"><fmt:message key="click-period"/></div>
                            </div>
                            <div class="margin-top-10">
                                <ul>
                                    <li><fmt:message key="click-espn"/></li>
                                </ul>
                            </div>
                        </div>

                        <div class="inner-seperator"></div>

                        <div class="clearfix">
                            <div class="row">
                                <div class="span">
                                    <div class="item-name"><fmt:message key="avaya"/></div>
                                    <div class="item-desc"><fmt:message key="avaya-position"/></div>
                                </div>
                                <div class="item-period pull-right span"><fmt:message key="avaya-period"/></div>
                            </div>
                            <div class="margin-top-10">
                                <ul>
                                    <li><fmt:message key="avaya-ipapp"/></li>
                                    <li><fmt:message key="avaya-eua"/></li>
                                    <li><fmt:message key="avaya-delta"/></li>
                                </ul>
                            </div>
                        </div>

                        <div class="inner-seperator"></div>

                        <div class="clearfix">
                            <div class="row">
                                <div class="span">
                                    <div class="item-name"><fmt:message key="mega"/></div>
                                    <div class="item-desc"><fmt:message key="mega-position"/></div>
                                </div>
                                <div class="item-period pull-right span"><fmt:message key="mega-period"/></div>
                            </div>
                            <div class="margin-top-10">
                                <ul>
                                    <li><fmt:message key="mega-erp"/></li>
                                </ul>
                            </div>
                        </div>
		        	</div>	
		        </div>	        	
		        <!-- /education-->

		        <div class="seperator"></div>

	      	  	<div class="row">
	      			<div class="span section-title">
                        <fmt:message key="education"/>
			        </div>
	        		
	        		<div class="span section-body">
		        		
			        	<div class="clearfix">
			        		<div class="row">
				        		<div class="span">
				        			<div class="item-name"><fmt:message key="uniban-as"/></div>
				        			<div class="item-desc"><fmt:message key="uniban"/></div>
				        		</div>	
				        		<div class="item-period pull-right span"><fmt:message key="uniban-as-period"/></div>
				        	</div>
				        </div>

		        	</div>	
		        </div>	        	
		        <!-- /education-->

		        <div class="seperator"></div>

      			<div class="row">
	      			<div class="span section-title">
                        <fmt:message key="skills"/>
			        </div>
	        		
	        		<div class="span section-body">
		        		
		        		<div class="clearfix">
			        		
			        		<div class="subject-name"><fmt:message key="technical"/></div>
					        <ul>
								<li><fmt:message key="technical-achitecture"/></li>
                                <li><fmt:message key="technical-software"/></li>
                                <li><fmt:message key="technical-frameworks"/></li>
                                <li><fmt:message key="technical-infra"/></li>
                                <li><fmt:message key="technical-ide"/></li>
                                <li><fmt:message key="technical-database"/></li>
                                <li><fmt:message key="technical-containers"/></li>
                                <li><fmt:message key="technical-os"/></li>
							</ul>
								
							<div class="margin-bottom-10"></div>

							<div class="subject-name"><fmt:message key="languages"/></div>
							<ul>
								<li><fmt:message key="portuguese"/></li>
								<li><fmt:message key="english"/></li>
							</ul>
				       
				        </div>	

		        	</div>	
		        </div>	        	
		        <!-- /skills-->

		        <div class="seperator"></div>

		        <div class="row">
		      		<div class="span section-title">
                        <fmt:message key="certificates"/>
				    </div>
				    <div class="span section-body">
				    	<ul>
                            <li><fmt:message key="ecmjea"/></li>
							<li><fmt:message key="ocpjbcd"/></li>
							<li><fmt:message key="scwcd"/></li>
							<li><fmt:message key="scjp"/></li>
						</ul>
				    </div>	
		        </div>
		        <!-- /awards-->

                <div class="seperator"></div>

                <div class="row">
                    <div class="span section-title">
                        <fmt:message key="trainning"/>
                    </div>
                    <div class="span section-body">
                        <ul>
                            <li><fmt:message key="trainning-rr75"/></li>
                            <li><fmt:message key="trainning-rr71"/></li>
                            <li><fmt:message key="trainning-fj91"/></li>
                            <li><fmt:message key="trainning-ejb"/></li>
                            <li><fmt:message key="trainning-ajava"/></li>
                            <li><fmt:message key="trainning-pjava"/></li>
                        </ul>
                    </div>
                </div>
                <!-- /courses-->

			    <div class="clearfix margin-bottom-10 pull-right">
			    	<a class="dotted" href="javascript:;"
			    	 onclick="jQuery('html,body').animate({scrollTop: jQuery('.header').offset().top}, 'slow');"
			    	>
                    <fmt:message key="top"/>
			    	</a>
			    </div>

      		</div> <!-- /main -->

    	</div> <!-- /container -->
	<script src="js/jquery-1.8.2.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>	
	<script>
	jQuery(document).ready(function() {
		jQuery('[rel="tooltip"]').tooltip({trigger : 'hover'});	
	})
	</script>
	</body>
</html>	
