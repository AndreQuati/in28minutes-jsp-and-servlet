<%@include file="../common/header.jspf"%>
<%@include file="../common/navigation.jspf"%>

	<div class="container">
		<H1>Your new action items</H1>
		
		<form action="/add-todo.do" method="post">
			<fieldset class="form-group">
				<label>Description</label>
				<input type="text" name="inpTodo" class="form-control"/><br/>
			</fieldset>
			<fieldset class="form-group">
				<label>Category</label>
				<input type="text" name="inpCategory" class="form-control"/><br/>
			</fieldset>
			
			<input type="submit" value="Submit" class="btn btn-success"/>
		</form>
			</div>
			
<%@include file="../common/footer.jspf"%>