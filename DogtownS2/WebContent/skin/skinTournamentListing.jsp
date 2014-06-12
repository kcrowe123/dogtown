<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	
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
<s:form action="dayOnePlayerListing" theme="simple">

<h1>Skin Tournament Listing</h1>


			
<h1><tiles:insertAttribute name="title" ignore="true" /></h1>


<table cellpadding="0" cellspacing="0" border="0" class="display" id="cc">  
	<thead>         
		<tr>    

		        <th>Name</th>             
				<th>Day 1</th>             
				<th>Day 2</th>                    	     
				
				
		</tr>     
	</thead>     
	<tbody>  
	
		<s:iterator value="#request.tournaments">
			<tr>
			      <td><s:property value="name"/></TD>
	             <TD>
			      <s:url id="url" action="dayOnePlayerListing">
			              <s:param value="id" name="tournament.id"/>
			          </s:url>
                  <s:a href="%{url}"><s:property value="firstDay"/></s:a>
	             </TD>
	             <TD>
			      <s:url id="url" action="dayTwoPlayerListing">
			              <s:param value="id" name="tournament.id"/>
			          </s:url>
                  <s:a href="%{url}"><s:property value="secondDay"/></s:a>
	             </TD>
			</tr>
		</s:iterator>
	</tbody> 
</table>		
	
</s:form>


