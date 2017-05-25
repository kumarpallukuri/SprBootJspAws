 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
  
 <div id="login-form">
      <div class="row">
          <div class="col-xs-offset-4 col-xs-4">
              <div class="well">
                  <form id="loginForm" method="POST" action="/login/">
                      <div class="form-group">
                          <label for="username" class="control-label">Username</label>
                          <input type="text" class="form-control" id="username" name="username" value="" required="true" title="Please enter you username">
                          <span class="help-block"></span>
                      </div>
                      <c:if test="${not otpRequired}">
	                      <div class="form-group">
	                          <label for="password" class="control-label">Password</label>
	                          <input type="password" class="form-control" id="password" name="password" value="" required="true" title="Please enter your password">
	                          <span class="help-block"></span>
	                      </div>
                      </c:if>
                      <c:if test="${ otpRequired}">
                      	<div class="form-group">
                          <label for="otp" class="control-label">OTP</label>
                          <input type="text" class="form-control" id="otp" name="otp" value="" required="true" title="Please enter your otp">
                          <span class="help-block"></span>
                      </div>
                      </c:if>
                      <div id="loginErrorMsg" class="alert alert-error hide">Wrong username/password</div>
                      <button type="submit" id="loginSubmitButton" class="btn btn-default btn-primary center-block">Login</button>
                      <c:if test="${not otpRequired}">
	                      <a id="forgotPass" href="#">
	                      	<span class="anchorText">forgot password ?</span>
	                      </a>
                      </c:if>
                      <c:if test="${otpRequired}">
	                      <a id="resentOTP" href="#">
	                      	<span class="anchorText">Resend OTP</span>
	                      </a>
                      </c:if>
                  </form>
              </div>
          </div>
      </div>
  </div>