package org.andengine.entity.sprite.batch.vbo.andengine.engine.options;

import org.andengine.engine.options.*;
import org.andengine.engine.options.SoundOptions;

/**
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 23:13:07 - 22.11.2011
 */
public class AudioOptions {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private org.andengine.engine.options.SoundOptions mSoundOptions = new org.andengine.engine.options.SoundOptions();
	private MusicOptions mMusicOptions = new MusicOptions();

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public SoundOptions getSoundOptions() {
		return this.mSoundOptions;
	}

	public MusicOptions getMusicOptions() {
		return this.mMusicOptions;
	}

	public boolean needsSound() {
		return this.mSoundOptions.needsSound();
	}

	public org.andengine.engine.options.AudioOptions setNeedsSound(final boolean pNeedsSound) {
		this.mSoundOptions.setNeedsSound(pNeedsSound);
		return this;
	}

	public boolean needsMusic() {
		return this.mMusicOptions.needsMusic();
	}

	public org.andengine.engine.options.AudioOptions setNeedsMusic(final boolean pNeedsMusic) {
		this.mMusicOptions.setNeedsMusic(pNeedsMusic);
		return this;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
