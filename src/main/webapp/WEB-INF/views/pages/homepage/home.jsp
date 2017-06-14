<div class="homeSearchSection">
	<img class="homepageWorkerImg" src="static/images/homeWorker.jpg">
   <h1><span class="highLightTerm">WorkTarget</span> Find workers around you and get your work done !!</h1>
    <form name="searchform" id="searchform">
    		<section id="filteringSection">
     		 <div class="form-group">
     		 	<label class="control-label">Profession</label>
     		 	<input type="text" class="form-control" id="profession" name="profession" ng-model="user.proffession" 
          		  title="Please enter your profession">
           </div>
           <div class="form-group">
           	<label class="control-label">City</label>
                <input type="text" class="form-control" id="city" name="city" ng-model="user.city" 
          		  title="Please enter your city">
            </div>
                <button type="submit" class="btn btn-default btn-primary" title="Search"> 
            		<span class="glyphicon glyphicon-search"></span>
            </button>
           </section>
           <section id="locateSection">
           		<div class="orText">OR</div>
           		<button type="button" class="btn btn-default btn-primary center-block" title="Find workers in map" onclick="window.location.href='/locateWorkers'"> 
            		<span class="glyphicon glyphicon-map-marker"></span>
            		<span class="locateButtonText">Locate Workers</span>
            	</button>
           </section>
    </form>	
</div>
