<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


    <link rel="stylesheet" type="text/css"  href="/DogtownS2/css/dogtown_page.css"  />
    <link rel="stylesheet" type="text/css"  href="/DogtownS2/css/dogtown_table_jui.css"  /> 
    <link rel="stylesheet" type="text/css"  href="/DogtownS2/themes/smoothness/jquery-ui-1.8.4.custom.css"  />    

    <script type="text/javascript" src="/DogtownS2/javascript/jquery.js"></script>
    <script type="text/javascript" src="/DogtownS2/javascript/jquery.dataTables.js"></script>
    <script type="text/javascript" src="/DogtownS2/javascript/jquery.dataTables.min.js"></script>
    
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				oTable = $('#cc').dataTable({
					"bJQueryUI": true,
					"sPaginationType": "full_numbers"		
				});
			} );
		</script>
	    				
<s:form id="tournamentListing" theme="simple">

<h1><tiles:insertAttribute name="title" ignore="true"/></h1>
<table cellpadding="0" cellspacing="0" border="0" class="display" id="cc">  
	<thead>         
		<tr>    

		        <th>Tournament Name</th>             
				<th>First Day</th>             
				<th>Second Day</th> 
				<th># Pl</th>                      	     
		</tr>     
	</thead>     
	<tbody>  
		<s:iterator value="#request.tournaments">
			<tr>
			      <td><s:url id="url" action="editTournament">
			              <s:param value="id" name="tournament.id"/>
			              <s:param value="true" name="edit"/>
			          </s:url>
                      <s:a href="%{url}"><s:property value="name"/></s:a></TD>
	             <TD><s:property value="firstDay" /></TD>
			     <TD><s:property value="secondDay" /></TD>
			     <TD><s:property value="totalNumberOfPlayers" /></TD>
			</tr>
		</s:iterator>
	</tbody> 
</table>

<s:submit id="addNew" type="submit" action="addNewTournament" value="Add Tournament"/>

	
</s:form>


