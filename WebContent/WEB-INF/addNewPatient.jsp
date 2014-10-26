
<div id = "form1" style= "">
<form class="form-horizontal" action="add"   >
<fieldset>

<!-- Form Name -->
<legend>Add new Patient</legend>

<!-- Text input-->
<div class="form-group"  >
  <label class="col-md-4 control-label" for="NameID">Name</label>  
  <div class="col-md-6">
  <input id="NameID" name="NameID" type="text" placeholder="Name" class="form-control input-md">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="firstNameId">First Name</label>  
  <div class="col-md-6">
  <input id="firstNameId" name="firstNameId" type="text" placeholder="First Name" class="form-control input-md"> 
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="lastNameID">Last Name</label>  
  <div class="col-md-6">
  <input id="lastNameID" name="lastNameID" type="text" placeholder="Last Name" class="form-control input-md">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="ageId">Age</label>  
  <div class="col-md-2">
  <input id="ageId" name="ageId" type="text" placeholder="Age" class="form-control input-md">
  </div>
</div>

<!-- Multiple Radios (inline) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="sexId">Sex</label>
  <div class="col-md-4"> 
    <label class="radio-inline" for="sexId-0">
      <input type="radio" name="sexId" id="sexId-0" value="Male" checked="checked">
      Male
    </label> 
    <label class="radio-inline" for="sexId-1">
      <input type="radio" name="sexId" id="sexId-1" value="Female">
      Female
    </label>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="adressId">Address</label>  
  <div class="col-md-6">
  <input id="adressId" name="adressId" type="text" placeholder="Address" class="form-control input-md">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="aboutId">Work Place/position</label>  
  <div class="col-md-6">
  <input id="aboutId" name="aboutId" type="text" placeholder="Work Place/position" class="form-control input-md">
  </div>
</div>
  
<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="diagnosisId">DiagnosisId at arrived</label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="diagnosisId" name="diagnosisId"></textarea>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submitId"></label>
  <div class="col-md-4">
    <button id="submitId" name="submitId" class="btn btn-primary">Submit</button>
  </div>
</div>

</fieldset>
</form>
</div>