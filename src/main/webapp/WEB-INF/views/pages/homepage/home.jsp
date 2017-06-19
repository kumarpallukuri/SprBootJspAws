<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<script src="static/js/app/homepage/home.js"></script>

<div ng-app="wtApp" ng-controller="homePageController" class="homeSearchSection">
	<img class="homepageWorkerImg" src="static/images/homeWorker.jpg">
   <h1><span class="highLightTerm">WorkTarget</span> Find workers around you and get your work done !!</h1>
    <form name="searchform" id="searchform" method="post" ng-submit="searchForWorkers();" novalidate>
    		<section id="filteringSection">
    		<c:if test="${SearchReturnedNoResults}">
	    		<div class="alert alert-danger">
				  Your Search did not return any results !!
				</div>
			</c:if>
     		 <div class="form-group">
     		 	<label class="control-label">Profession</label>
     		 	<input type="text" class="form-control" id="profession" name="profession" ng-model="profession" 
          		  title="Please enter your profession" required>
          		  <label class=" pull-left smallFont searchEg">Eg: Electrician, Driver
          		  	<span class="help-block displayInline">
                     	<span ng-show="searchform.$submitted">
                     		<span class="errorText" ng-show="searchform.profession.$error.required"> - REQUIRED</span> 
                     	</span>
                    </span>
          		  </label>
           </div>
           <div class="form-group">
           		<label class="control-label">City</label>
                <input type="text" class="form-control" id="city" name="city" ng-model="city" 
          		  title="Please enter your city" required>
          		  <label class=" pull-left smallFont searchEg">Eg: Chennai, Hyderabad
          		  	<span class="help-block displayInline">
                     	<span ng-show="searchform.$submitted">
                     		<span class="errorText" ng-show="searchform.city.$error.required"> - REQUIRED</span> 
                     	</span>
                    </span>
          		  </label>
            </div>
                <button type="submit" class="btn btn-default btn-primary" title="Search"> 
            		<span class="glyphicon glyphicon-search"></span>
            </button>
           </section>
           <section id="locateSection">
           		<span class="orText searchEg">Or you can search in map&nbsp;-&nbsp;</span>
           		<button type="button" class="btn btn-default btn-primary" title="Find workers in map" onclick="window.location.href='/locateWorkers'"> 
            		<span class="glyphicon glyphicon-map-marker"></span>
            		<span class="locateButtonText">Locate Workers</span>
            	</button>
           </section>
    </form>	
</div>
