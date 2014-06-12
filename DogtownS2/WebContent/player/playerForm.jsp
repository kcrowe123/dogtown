<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Dogtown Invitational - Player</title>
	</head>
	
	<body>

	    			
 <s:form id="playerForm"  theme="simple">
					
					<h1>Player Form</h1>
					<br/><br/>
					<div id="content-title">
					<h2>Personal Information</h2>
					<br/>
					<table>
						<tr>
							<td class="align-left">
								First Name:
							</td>
							<td class="align-left">
								<s:textfield id="firstNameText" value="%{player.firstName}" name="player.firstName" size="20"/>
							</td>
							<td class="align-left">
								Last Name:
							</td>
							<td class="align-left">
								<s:textfield id="lastNameText" value="%{player.lastName}" name="player.lastName" size="20"/>
							</td>
							<td class="align-left">
								Suffix:
							</td>
							<td class="align-left">
								<s:textfield id="suffixText" value="%{player.suffix}" name="player.suffix"/>
							</td>
						</tr>
						<tr>
							<td class="align-left">
								Date of Birth:
							</td>
							<td class="align-left">
								<s:textfield id="dateOfBirthText" value="%{getText('format.date',{player.dateOfBirth})}" name="player.dateOfBirth"/>
							</td>
						</tr>
					</table>
					</div>
					
					<br/><br/>
					
					<div id="content-title">
					<h2>Contact Information</h2>
					<br/>
					<table>
						<tr>
							<td class="align-left">
								Street:
							</td>
							<td class="align-left">
								<s:textfield id="streetText" value="%{player.address.street}" name="player.address.street" size="30"/>
							</td>
						</tr>
						<tr>
							<td class="align-left">
								City:
							</td>
							<td class="align-left">
								<s:textfield id="cityText" value="%{player.address.city}" name="player.address.city" size="20"/>
							</td>
							<td class="align-left">
								State:
							</td>
							<td class="align-left">
								<s:textfield id="stateText" value="%{player.address.state}" name="player.address.state" size="2" maxlength="2"/>
							</td>
							<td class="align-left">
								Zip Code:
							</td>
							<td class="align-left">
								<s:textfield id="zipCodeText" value="%{player.address.zipCode}" name="" size="5" maxlength="5"/>
							</td>
						</tr>
						<tr>
							<td class="align-left">
								Phone:
							</td>
							<td class="align-left">
								<s:textfield id="phoneNumberText" value="%{player.phoneNumber}" name="player.phoneNumber" size="12" maxlength="12"/>
							</td>
							<td class="align-left">
								Email:
							</td>
							<td colspan="2" class="align-left">
								<s:textfield id="emailAddressText" value="%{player.emailAddress}" name="player.emailAddress" size="30"/>
							</td>
						</tr>
					</table>
					</div>
					
					<br/><br/>
					
					<table>
						<tr>
							<td>
								<s:submit id="save" type="submit" action="savePlayer" value="Save"/>
							</td>
							<td>
								<s:submit id="cancel" type="submit" action="%{cancel}" value="Return" immediate="true"/>
							</td>
						</tr>
					</table>
					</s:form>

	
	</body>
	</html>


