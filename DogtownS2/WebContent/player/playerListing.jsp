<%@ taglib prefix="s" uri="/struts-tags"%>
    <link rel="stylesheet" type="text/css"  href="/DogtownS2/css/dogtown_page.css"  />
    <link rel="stylesheet" type="text/css"  href="/DogtownS2/css/dogtown_table_jui.css"  /> 
    <link rel="stylesheet" type="text/css"  href="/DogtownS2/themes/smoothness/jquery-ui-1.8.4.custom.css"  />    

    <script type="text/javascript" src="/DogtownS2/javascript/jquery.js"></script>
    <script type="text/javascript" src="/DogtownS2/javascript/jquery.dataTables.js"></script>
    <script type="text/javascript" src="/DogtownS2/javascript/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/DogtownS2/javascript/ColReorderWithResize.js"></script>
    
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				oTable = $('#cc').dataTable({
					"bJQueryUI": true,
					"sPaginationType": "full_numbers",
					"sDom": "Rlfrtip"		
				});
			} );
		</script>
<s:form id="playerListing" theme="simple">

<h1>Player Listing</h1>
					
	<table cellpadding="0" cellspacing="0" border="0" class="display" id="cc">  
	<thead>         
		<tr>    

		        <th>Name</th>             
				<th>Address</th>             
				<th>Birth Date</th> 
				<th>Phone Number</th>   
				<th>Email Address</th>                    	     
		</tr>     
	</thead>     
	<tbody>  
		<s:iterator value="#request.players">
			<tr>
			      <td><s:url id="url" action="editPlayer">
			              <s:param value="id" name="player.id"/>
			          </s:url>
                      <s:a href="%{url}"><s:property value="fullName"/></s:a></td>
	             <td><s:property value="address.mailingAddress" /></td>
			     <td><s:property value="getText('format.date',{dateOfBirth})" /></td>
			     <td><s:property value="phoneNumber" /></td>
			     <td><s:property value="emailAddress" /></td>  
			</tr>
		</s:iterator>
	</tbody> 
</table>
<table>
	<tr>
		<td><s:submit value="Add New Player" action="addNewPlayer"/></td>
	</tr>
</table>
					
</s:form>



