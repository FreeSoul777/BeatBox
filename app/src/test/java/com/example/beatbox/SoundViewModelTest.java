package com.example.beatbox;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SoundViewModelTest extends TestCase {

    private BeatBox mBeatBox;
    private Sound mSound;
    private SoundViewModel mSubject;

    @Before
    public void setUp() throws Exception {
        mBeatBox = mock(BeatBox.class);
        mSound = new Sound("assetPath");
        mSubject = new SoundViewModel(mBeatBox);
        mSubject.setmSound(mSound);
    }


    public void testExposesSoundNameAsTitle() throws Exception {
        assertThat(mSubject.getTitle(), is(mSound.getmName()));
    }

    public void testCallsBeatBoxPlayOnButtonClicked() throws Exception {
        mSubject.onButtonClicked();

        verify(mBeatBox).play(mSound);
    }
}