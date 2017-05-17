/*
 * Catroid: An on-device visual programming system for Android devices
 * Copyright (C) 2010-2017 The Catrobat Team
 * (<http://developer.catrobat.org/credits>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * An additional term exception under section 7 of the GNU Affero
 * General Public License, version 3, is available at
 * http://developer.catrobat.org/license_additional_term
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.catrobat.catroid.uiespresso.content.brick;

import android.support.test.InstrumentationRegistry;

import org.catrobat.catroid.ProjectManager;
import org.catrobat.catroid.R;
import org.catrobat.catroid.common.LookData;
import org.catrobat.catroid.common.ScreenValues;
import org.catrobat.catroid.content.Project;
import org.catrobat.catroid.content.Script;
import org.catrobat.catroid.content.SingleSprite;
import org.catrobat.catroid.content.Sprite;
import org.catrobat.catroid.content.StartScript;
import org.catrobat.catroid.content.bricks.AskBrick;
import org.catrobat.catroid.content.bricks.BroadcastBrick;
import org.catrobat.catroid.content.bricks.BroadcastReceiverBrick;
import org.catrobat.catroid.content.bricks.ChangeColorByNBrick;
import org.catrobat.catroid.content.bricks.ChangeXByNBrick;
import org.catrobat.catroid.content.bricks.NextLookBrick;
import org.catrobat.catroid.content.bricks.PlaceAtBrick;
import org.catrobat.catroid.content.bricks.SetBackgroundBrick;
import org.catrobat.catroid.content.bricks.SetSizeToBrick;
import org.catrobat.catroid.content.bricks.WaitBrick;
import org.catrobat.catroid.content.bricks.WhenBrick;
import org.catrobat.catroid.content.bricks.WhenConditionBrick;
import org.catrobat.catroid.content.bricks.WhenTouchDownBrick;
import org.catrobat.catroid.io.StorageHandler;
import org.catrobat.catroid.stage.StageActivity;
import org.catrobat.catroid.ui.ScriptActivity;
import org.catrobat.catroid.uiespresso.util.BaseActivityInstrumentationRule;
import org.catrobat.catroid.uiespresso.util.UiTestUtils;
import org.catrobat.catroid.uiespresso.util.matchers.StageMatchers;
import org.catrobat.catroid.utils.UtilUi;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isFocusable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static org.catrobat.catroid.uiespresso.content.brick.BrickTestUtils.checkIfBrickAtPositionShowsString;
import static org.catrobat.catroid.uiespresso.content.brick.BrickTestUtils.createNewVariableOnSpinnerInitial;
import static org.catrobat.catroid.uiespresso.content.brick.BrickTestUtils.createProjectAndGetStartScript;
import static org.catrobat.catroid.uiespresso.content.brick.BrickTestUtils.enterStringInFormulaTextFieldOnBrickAtPosition;
import static org.catrobat.catroid.uiespresso.content.brick.BrickTestUtils.enterValueInFormulaTextFieldOnBrickAtPosition;

public class BroadcastBricksTest {
	private static final int PROJECT_WIDTH = 480;
	private static final int PROJECT_HEIGHT = 800;

	private int brickPosition;

	@Rule
	public BaseActivityInstrumentationRule<ScriptActivity> baseActivityTestRule = new
			BaseActivityInstrumentationRule<>(ScriptActivity.class, true, false);

	@Before
	public void setUp() throws Exception {
		brickPosition = 1;
		Script script = createProjectAndGetStartScriptWithImages("BroadcastBrickTest");
		//script.addBrick(new ChangeColorByNBrick());

		baseActivityTestRule.launchActivity(null);
	}

	@Test
	public void testChangeColorByNBrick() {
		int valToChange = 20;


		createNewVariableOnSpinnerInitial(R.id.brick_ask_spinner, 3,"myvariable");
	/*	onScriptList().atPosition(position).onChildView(withId(editTextResourceId))
				.perform(click());
		onView(withId( R.id.brick_when_condition_edit_text)).perform(click());*/


		//enterStringInFormulaTextFieldOnBrickAtPosition("'myvariable'='ja'", R.id.brick_when_condition_edit_text, 4);



		onView(withId(R.id.button_play)).perform(click());
		byte[] blue = {0, (byte) 162, (byte) 232, (byte) 255};
		byte[] red = {0, (byte) 237, (byte) 28, (byte) 36};


		onView(isFocusable())
				.check(matches(StageMatchers.isColorAtPx(blue, 1, 1)));

/*		onView(isFocusable()).perform(click());

		onView(isFocusable())
				.check(matches(StageMatchers.isColorAtPx(red, 1, 1)));*/


	//	checkIfBrickAtPositionShowsString(0, R.string.brick_when_started);
	//	checkIfBrickAtPositionShowsString(brickPosition, R.string.brick_change_color);
		/*enterValueInFormulaTextFieldOnBrickAtPosition(valToChange, R.id.brick_change_color_by_edit_text,
				brickPosition);*/
	}
	@Test
	public void checkForBlueSpriteColor() {


		checkIfBrickAtPositionShowsString(0, R.string.brick_when_started);
		//brickPosition = 1;

		//Project project = createProjectWithBlueSprite("blueProject");
		//baseActivityTestRule.launchActivity(null);

	//	byte[] blue = {0, (byte) 162, (byte) 232, (byte) 255};

		//color matcher only accepts a GL20View, this can be aquired by getting the only focusable element in the stage
	/*	onView(isFocusable())
				.check(matches(StageMatchers.isColorAtPx(blue, 1, 1)));*/
	}

	public Script createProjectAndGetStartScriptWithImages(String projectName) {
		Project project = new Project(null, projectName);
		Sprite sprite = new Sprite("testSprite");
		Script script = new StartScript();



		sprite.addScript(script);

		// blue Sprite
		//Sprite blueSprite = new SingleSprite("blueSprite");
		//StartScript blueStartScript = new StartScript();
		LookData blueLookData = new LookData();
		String blueImageName = "blue_image.bmp";
		blueLookData.setLookName(blueImageName);
		sprite.getLookDataList().add(blueLookData);

		LookData redLookData = new LookData();
		String redImageName = "red_image.bmp";
		redLookData.setLookName(redImageName);
		sprite.getLookDataList().add(redLookData);


		script.addBrick(new PlaceAtBrick(0, 0));
		script.addBrick(new SetSizeToBrick(5000));
		script.addBrick(new AskBrick("Bereit zum Testen?"));
		script.addBrick(new WhenConditionBrick());
		//script.addBrick(new WhenTouchDownBrick());
		script.addBrick(new WaitBrick(5000));
		script.addBrick(new BroadcastBrick("xx"));
		script.addBrick(new BroadcastReceiverBrick("xx"));
		//script.addBrick(new WaitBrick(3000));
		script.addBrick(new NextLookBrick());
		//script.addBrick(new SetBackgroundBrick());
		//script.addBrick(new  )
		sprite.addScript(script);

		project.getDefaultScene().addSprite(sprite);

		StorageHandler.getInstance().saveProject(project);
		File blueImageFile = UiTestUtils.saveFileToProject(project.getName(), project.getDefaultScene().getName(),
				blueImageName,
				org.catrobat.catroid.test.R.raw.blue_image, InstrumentationRegistry.getContext(),
				UiTestUtils.FileTypes.IMAGE);


		File redImageFile = UiTestUtils.saveFileToProject(project.getName(), project.getDefaultScene().getName(),
				redImageName,
				org.catrobat.catroid.test.R.raw.red_image, InstrumentationRegistry.getContext(),
				UiTestUtils.FileTypes.IMAGE);

		blueLookData.setLookFilename(blueImageFile.getName());
		redLookData.setLookFilename(redImageFile.getName());



		project.getDefaultScene().addSprite(sprite);
		ProjectManager.getInstance().setProject(project);
		ProjectManager.getInstance().setCurrentSprite(sprite);
		return script;
	}


	public Project createProjectWithBlueSprite(String projectName) {
		ScreenValues.SCREEN_HEIGHT = PROJECT_HEIGHT;
		ScreenValues.SCREEN_WIDTH = PROJECT_WIDTH;

		Project project = new Project(null, projectName);

		// blue Sprite
		Sprite blueSprite = new SingleSprite("blueSprite");
		StartScript blueStartScript = new StartScript();
		LookData blueLookData = new LookData();
		String blueImageName = "blue_image.bmp";

		blueLookData.setLookName(blueImageName);

		blueSprite.getLookDataList().add(blueLookData);

		blueStartScript.addBrick(new PlaceAtBrick(0, 0));
		blueStartScript.addBrick(new SetSizeToBrick(5000));
		blueSprite.addScript(blueStartScript);

		project.getDefaultScene().addSprite(blueSprite);

		StorageHandler.getInstance().saveProject(project);
		File blueImageFile = UiTestUtils.saveFileToProject(project.getName(), project.getDefaultScene().getName(),
				blueImageName,
				org.catrobat.catroid.test.R.raw.blue_image, InstrumentationRegistry.getContext(),
				UiTestUtils.FileTypes.IMAGE);

		blueLookData.setLookFilename(blueImageFile.getName());

	/*	StorageHandler.getInstance().saveProject(project);
		ProjectManager.getInstance().setProject(project);
		ProjectManager.getInstance().setCurrentSprite(blueSprite);
		UtilUi.updateScreenWidthAndHeight(InstrumentationRegistry.getContext());*/

		return project;
	}
}
