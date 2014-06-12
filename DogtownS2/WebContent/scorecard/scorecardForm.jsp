
<%@ taglib prefix="s" uri="/struts-tags"%>



	    				
		    		<s:form id="scorecardForm" action="saveScorecard" theme="simple">
					
					<h1>Scorecard</h1>
					
					<table>
						<tr>
							<td class="align-left" >
								<s:text name="xxx"/>
							</td>
							<td class="align-left">
								<s:text name="#session.tournamentKey.name"/>
							</td>
						</tr>
						<tr>
							<td class="align-left">
								<s:text name="Player"/>
							</td>
							<td class="align-left">
								<s:property value="playerScorecard.player.fullName"/>
							</td>
						</tr>
					</table>
					
										<br/><br/>

					<h2>Day 1 <s:property value="playerScorecard.dayOneScorecard.day.course"/></h2>
					<br/>
<s:div id="dayOneScores" theme="simple">
						<table>
							<tr>
								<th>
									<span class="holeNums" id="d1h1">1</span>
								</th>
								<th>
									<span class="holeNums" id="d1h2">2</span>
								</th>
								<th>
									<span class="holeNums" id="d1h3">3</span>
								</th>
								<th>
									<span class="holeNums" id="d1h4">4</span>
								</th>
								<th>
									<span class="holeNums" id="d1h5">5</span>
								</th>
								<th>
									<span class="holeNums" id="d1h6">6</span>
								</th>
								<th>
									<span class="holeNums" id="d1h7">7</span>
								</th>
								<th>
									<span class="holeNums" id="d1h8">8</span>
								</th>
								<th>
									<span class="holeNums" id="d1h9">9</span>
								</th>
								<th>
									&nbsp;&nbsp;
								</th>
							    <th>
									&nbsp;&nbsp;
								</th>
							    <th>
									&nbsp;&nbsp;
								</th>
								<th>
									<span class="holeNums" id="d1h10">10</span>
								</th>
								<th>
									<span class="holeNums" id="d1h11">11</span>
								</th>
								<th>
									<span class="holeNums" id="d1h12">12</span>
								</th>
								<th>
									<span class="holeNums" id="d1h13">13</span>
								</th>
								<th>
									<span class="holeNums" id="d1h14">14</span>
								</th>
								<th>
									<span class="holeNums" id="d1h15">15</span>
								</th>
								<th>
									<span class="holeNums" id="d1h16">16</span>
								</th>
								<th>
									<span class="holeNums" id="d1h17">17</span>
								</th>
								<th>
									<span class="holeNums" id="d1h18">18</span>
								</th>
								<th>
									<s:text name="d1Total"/>
								</th>
							</tr>	
							<tr>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole1LabelText" name="playerScorecard.dayOneScorecard.firstHole" value="%{playerScorecard.dayOneScorecard.firstHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole2LabelText" name="playerScorecard.dayOneScorecard.secondHole" value="%{playerScorecard.dayOneScorecard.secondHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole3LabelText" name="playerScorecard.dayOneScorecard.thirdHole" value="%{playerScorecard.dayOneScorecard.thirdHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole4LabelText" name="playerScorecard.dayOneScorecard.fourthHole" value="%{playerScorecard.dayOneScorecard.fourthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole5LabelText" name="playerScorecard.dayOneScorecard.fifthHole" value="%{playerScorecard.dayOneScorecard.fifthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole6LabelText" name="playerScorecard.dayOneScorecard.sixthHole" value="%{playerScorecard.dayOneScorecard.sixthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole7LabelText" name="playerScorecard.dayOneScorecard.seventhHole" value="%{playerScorecard.dayOneScorecard.seventhHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole8LabelText" name="playerScorecard.dayOneScorecard.eigthHole" value="%{playerScorecard.dayOneScorecard.eigthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole9LabelText" name="playerScorecard.dayOneScorecard.ninthHole" value="%{playerScorecard.dayOneScorecard.ninthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									&nbsp;&nbsp;
								</td>
							    <td>
									<s:label id="day1holeTotalAfterNineLabelText"></s:label>
								</td>
							    <td>
									&nbsp;&nbsp;
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole10LabelText" name="playerScorecard.dayOneScorecard.tenthHole"  value="%{playerScorecard.dayOneScorecard.tenthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole11LabelText" name="playerScorecard.dayOneScorecard.eleventhHole" value="%{playerScorecard.dayOneScorecard.eleventhHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole12LabelText" name="playerScorecard.dayOneScorecard.twelthHole" value="%{playerScorecard.dayOneScorecard.twelthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole13LabelText" name="playerScorecard.dayOneScorecard.thirteenthHole" value="%{playerScorecard.dayOneScorecard.thirteenthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole14LabelText" name="playerScorecard.dayOneScorecard.fourteenthHole" value="%{playerScorecard.dayOneScorecard.fourteenthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole15LabelText" name="playerScorecard.dayOneScorecard.fifteenthHole" value="%{playerScorecard.dayOneScorecard.fifteenthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole16LabelText" name="playerScorecard.dayOneScorecard.sixteenthHole" value="%{playerScorecard.dayOneScorecard.sixteenthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole17LabelText" name="playerScorecard.dayOneScorecard.seventeenthHole" value="%{playerScorecard.dayOneScorecard.seventeenthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day1hole18LabelText" name="playerScorecard.dayOneScorecard.eighteenthHole" value="%{playerScorecard.dayOneScorecard.eighteenthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day1hole');"></s:textfield>
								</td>
								<td >
								    <s:label id="day1holeTotalLabelText" value="%{playerScorecard.dayOneScorecard.score}"></s:label>
								</td>
							</tr>
						</table>
</s:div>
					<h2>Day 2 <s:property value="playerScorecard.dayTwoScorecard.day.course"/></h2>
					<br/>
<s:div id="dayTwoScores" theme="simple">
						<table>
							<tr>
								<th>
									<s:text name="d2h1"/>
								</th>
								<th>
									<s:text name="d2h2"/>
								</th>
								<th>
									<s:text name="d2h3"/>
								</th>
								<th>
									<s:text name="d2h4"/>
								</th>
								<th>
									<s:text name="d2h5"/>
								</th>
								<th>
									<s:text name="d2h6"/>
								</th>
								<th>
									<s:text name="d2h7"/>
								</th>
								<th>
									<s:text name="d2h8"/>
								</th>
								<th>
									<s:text name="d2h9"/>
								</th>
								<th>
									&nbsp;&nbsp;
								</th>
							    <th>
									&nbsp;&nbsp;
								</th>
							    <th>
									&nbsp;&nbsp;
								</th>
								<th>
									<s:text name="d2h10"/>
								</th>
								<th>
									<s:text name="d2h11"/>
								</th>
								<th>
									<s:text name="d2h12"/>
								</th>
								<th>
									<s:text name="d2h13"/>
								</th>
								<th>
									<s:text name="d2h14"/>
								</th>
								<th>
									<s:text name="d2h15"/>
								</th>
								<th>
									<s:text name="d2h16"/>
								</th>
								<th>
									<s:text name="d2h17"/>
								</th>
								<th>
									<s:text name="d2h18"/>
								</th>
								<th>
									<s:text name="d2hTotalLabel" />
								</th>
							</tr>	
							<tr>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole1LabelText" name="playerScorecard.dayTwoScorecard.firstHole" value="%{playerScorecard.dayTwoScorecard.firstHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole2LabelText" name="playerScorecard.dayTwoScorecard.secondHole" value="%{playerScorecard.dayTwoScorecard.secondHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole3LabelText" name="playerScorecard.dayTwoScorecard.thirdHole" value="%{playerScorecard.dayTwoScorecard.thirdHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole4LabelText" name="playerScorecard.dayTwoScorecard.fourthHole" value="%{playerScorecard.dayTwoScorecard.fourthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole5LabelText" name="playerScorecard.dayTwoScorecard.fifthHole" value="%{playerScorecard.dayTwoScorecard.fifthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole6LabelText" name="playerScorecard.dayTwoScorecard.sixthHole" value="%{playerScorecard.dayTwoScorecard.sixthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole7LabelText" name="playerScorecard.dayTwoScorecard.seventhHole" value="%{playerScorecard.dayTwoScorecard.seventhHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole8LabelText" name="playerScorecard.dayTwoScorecard.eigthHole" value="%{playerScorecard.dayTwoScorecard.eigthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole9LabelText" name="playerScorecard.dayTwoScorecard.ninthHole" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									&nbsp;&nbsp;
								</td>
							    <td>
									<s:label id="day2holeTotalAfterNineLabelText"></s:label>
								</td>
							    <td>
									&nbsp;&nbsp;
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole10LabelText" name="playerScorecard.dayTwoScorecard.tenthHole" value="%{playerScorecard.dayTwoScorecard.tenthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole11LabelText" name="playerScorecard.dayTwoScorecard.eleventhHole" value="%{playerScorecard.dayTwoScorecard.eleventhHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole12LabelText" name="playerScorecard.dayTwoScorecard.twelthHole" value="%{playerScorecard.dayTwoScorecard.twelthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole13LabelText" name="playerScorecard.dayTwoScorecard.thirteenthHole" value="%{playerScorecard.dayTwoScorecard.thirteenthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole14LabelText" name="playerScorecard.dayTwoScorecard.fourteenthHole" value="%{playerScorecard.dayTwoScorecard.fourteenthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole15LabelText" name="playerScorecard.dayTwoScorecard.fifteenthHole" value="%{playerScorecard.dayTwoScorecard.fifteenthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole16LabelText" name="playerScorecard.dayTwoScorecard.sixteenthHole" value="%{playerScorecard.dayTwoScorecard.sixteenthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole17LabelText" name="playerScorecard.dayTwoScorecard.seventeenthHole" value="%{playerScorecard.dayTwoScorecard.seventeenthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td>
									<s:textfield cssClass="smallBox" id="day2hole18LabelText" name="playerScorecard.dayTwoScorecard.eighteenthHole" value="%{playerScorecard.dayTwoScorecard.eighteenthHole}" size="1" maxlength="2" onfocus="select();" onchange="totalScores('day2hole');"></s:textfield>
								</td>
								<td >
									
								</td>
							</tr>
						</table>
</s:div>	
						
						<table>
						<tr>
							<td>
								<s:submit id="save" type="submit" value="Save"/>
							</td>
							<td>
								<!--<s:submit id="cancel" type="submit" action="cancel" value="Return"/>-->
							</td>
						</tr>
					</table>
					</s:form>
<script type="text/javascript">
 calcNines('day1hole');
 calcNines('day2hole');
</script>

