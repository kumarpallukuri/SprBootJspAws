<script type="text/JavaScript" src='static/js/app/details/state.js'></script>
<script type="text/JavaScript" src='static/js/app/details/workersProfession.js'></script>
<script type="text/JavaScript" src='static/js/app/homepage/home.js'></script>


<div ng-app="wtApp" ng-controller="homeController">

		<div  class="homeSearchSection">
              <h1><span class="highLightTerm">WorkTarget</span> Find workers around you and get your work done !!</h1>
               <form name="searchform" id="searchform">
               		<section id="filteringSection">
	               		 <div class="form-group">
	               		 	<div id="selection">
	                          	<select id="proffession" ng-model="proffession" ng-click="showInputTextBox()"></select>
	                          </div>
	                     </div>
	                     <div class="form-group">
	                           <select id="workerState" onchange='selct_district(this.value)' ng-model="state"></select>
	                      </div>
	                      <div class="form-group hidden" id="districtlist">
	                           <select id="workerDistrict" ng-model="district"></select>
	                      </div>
	                       <div class="form-group">
	                           <button type="submit" class="btn btn-default btn-primary center-block"> 
		                      	Search
		                      </button>
	                      </div>
                      </section>
                      <section id="searchSection">
	                      <div id="otherInput" ng-show="otherInputTextBox">
	                      	<div class="form-group displayBlock">
	                    		 <input type="text" class="form-control" id="otherInputbox" name="otherInputbox" ng-model="proffessionOther" 
	                    		 placeholder="Please enter the profession .." required title="Please enter your profession">
	                        	 <span class="help-block"></span>
	                      	</div>
						  </div>
					  </section>
               </form>	
      </div>
      
      
</div>