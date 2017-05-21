  <div id="login-register-form">
      <div class="row">
          <div class="col-xs-offset-2 col-xs-4">
              <div class="well">
                  <form id="loginForm" method="POST" action="/login/" novalidate="novalidate">
                      <div class="form-group">
                          <label for="username" class="control-label">Username</label>
                          <input type="text" class="form-control" id="username" name="username" value="" required="" title="Please enter you username">
                          <span class="help-block"></span>
                      </div>
                      <div class="form-group">
                          <label for="password" class="control-label">Password</label>
                          <input type="password" class="form-control" id="password" name="password" value="" required="" title="Please enter your password">
                          <span class="help-block"></span>
                      </div>
                      <div id="loginErrorMsg" class="alert alert-error hide">Wrong username/password</div>
                      <button type="submit" id="loginSubmitButton" class="btn  btn-success  btn-block">Login</button>
                  </form>
              </div>
          </div>
          <div class="col-offset-xs-2 col-xs-4">
              <a id="registerButton" href="/register">
              	<span class="anchorText">Register</span>
              </a>
          </div>
      </div>
  </div>