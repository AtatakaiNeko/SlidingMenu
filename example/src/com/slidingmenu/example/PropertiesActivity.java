package com.slidingmenu.example;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.slidingmenu.lib.SlidingMenu;

public class PropertiesActivity extends BaseActivity
{

	private SeekBar mAboveMarginSeek;
	private SeekBar mBehindMarginSeek;

	public PropertiesActivity()
	{
		super(R.string.properties);
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setSlidingActionBarEnabled(true);

		setContentView(R.layout.properties);

		mAboveMarginSeek = (SeekBar) findViewById(R.id.margin_size_above);
		mAboveMarginSeek.setMax(getResources().getDisplayMetrics().widthPixels);
		mAboveMarginSeek.setProgress(20);
		mAboveMarginSeek.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
		{

			@Override
			public void onStopTrackingTouch(SeekBar seekBar)
			{
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar)
			{
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
				getSlidingMenu().setTouchMarginValueAbove(progress);
			}
		});

		mBehindMarginSeek = (SeekBar) findViewById(R.id.margin_size_behind);
		mBehindMarginSeek.setMax(getResources().getDisplayMetrics().widthPixels);
		mBehindMarginSeek.setProgress(20);
		mBehindMarginSeek.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
		{

			@Override
			public void onStopTrackingTouch(SeekBar seekBar)
			{
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar)
			{
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
				getSlidingMenu().setTouchMarginValueBehind(progress);
			}
		});

		// touch mode stuff
		RadioGroup touchAbove = (RadioGroup) findViewById(R.id.touch_above);
		touchAbove.check(R.id.touch_above_margin);
		touchAbove.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId)
			{
				switch (checkedId)
				{
				case R.id.touch_above_full:
					getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
					mAboveMarginSeek.setEnabled(false);
					break;
				case R.id.touch_above_margin:
					getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
					mAboveMarginSeek.setEnabled(true);
					break;
				}
			}
		});

		RadioGroup touchBehind = (RadioGroup) findViewById(R.id.touch_behind);
		touchBehind.check(R.id.touch_behind_margin);
		touchBehind.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId)
			{
				switch (checkedId)
				{
				case R.id.touch_behind_full:
					getSlidingMenu().setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);
					mBehindMarginSeek.setEnabled(false);
					break;
				case R.id.touch_behind_margin:
					getSlidingMenu().setTouchModeBehind(SlidingMenu.TOUCHMODE_MARGIN);
					mBehindMarginSeek.setEnabled(true);
					break;
				}
			}
		});

		// scroll scale stuff
		SeekBar scrollScale = (SeekBar) findViewById(R.id.scroll_scale);
		scrollScale.setMax(1000);
		scrollScale.setProgress(333);
		scrollScale.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
		{
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar)
			{
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar)
			{
				getSlidingMenu().setBehindScrollScale(
						(float) seekBar.getProgress() / seekBar.getMax());
			}
		});

		// behind width stuff
		SeekBar behindWidth = (SeekBar) findViewById(R.id.behind_width);
		behindWidth.setMax(1000);
		behindWidth.setProgress(750);
		behindWidth.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
		{
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar)
			{
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar)
			{
				float percent = (float) seekBar.getProgress() / seekBar.getMax();
				getSlidingMenu().setBehindWidth((int) (percent * getSlidingMenu().getWidth()));
			}
		});

		// fading stuff
		CheckBox fadeEnabled = (CheckBox) findViewById(R.id.fade_enabled);
		fadeEnabled.setChecked(true);
		fadeEnabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			{
				getSlidingMenu().setFadeEnabled(isChecked);
			}
		});
		SeekBar fadeDeg = (SeekBar) findViewById(R.id.fade_degree);
		fadeDeg.setMax(1000);
		fadeDeg.setProgress(666);
		fadeDeg.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
		{
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar)
			{
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar)
			{
				getSlidingMenu().setFadeDegree((float) seekBar.getProgress() / seekBar.getMax());
			}
		});
	}

}
