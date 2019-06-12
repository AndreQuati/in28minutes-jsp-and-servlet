<%@include file="../common/header.jspf"%>
<%@include file="../common/navigation.jspf"%>

	<div class="container">
		<H1>Welcome ${name}</H1>
		<p>Your todos are: </p>
		
		<table class="table table-striped">
			<caption></caption>
			<thead>
				<th>Description</th>
				<th>Category</th>
				<th>Actions</th>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="eachTodo">
					<tr>
						<td>${eachTodo.name}</td>
						<td>${eachTodo.category}</td>
						<td><a class="btn btn-danger" href="delete-todo.do?todo=${eachTodo.name}&category =${eachTodo.category }">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			
		<a class="btn btn-success" href="/add-todo.do">Add New Todo</a>
	</div>
			
<%@include file="../common/footer.jspf"%>