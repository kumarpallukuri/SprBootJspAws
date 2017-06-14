<div  class="homeSearchSection">
	<img class="homepageWorkerImg" src="static/images/homeWorker.jpg">
   <h1><span class="highLightTerm">WorkTarget</span> Find workers around you and get your work done !!</h1>
    <form name="searchform" id="searchform">
    		<section id="filteringSection">
     		 <div class="form-group">
     		 	<input type="text" class="form-control" id="profession" name="profession" ng-model="user.proffession" 
          		 placeholder="Please enter the profession .." title="Please enter your profession">
           </div>
           <div class="form-group">
                <input type="text" class="form-control" id="city" name="city" ng-model="user.city" 
          		 placeholder="Please enter the city.." title="Please enter your city">
            </div>
                <button type="submit" class="btn btn-default btn-primary" title="Search"> 
            		<span class="glyphicon glyphicon-search"></span>
            </button>
           </section>
    </form>	
</div>
