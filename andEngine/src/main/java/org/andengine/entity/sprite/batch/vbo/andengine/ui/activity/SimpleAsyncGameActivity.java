package org.andengine.entity.sprite.batch.vbo.andengine.ui.activity;

import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.*;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.ActivityUtils;
import org.andengine.util.call.Callback;
import org.andengine.util.progress.IProgressListener;
import org.andengine.util.progress.ProgressCallable;

/**
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 01:24:18 - 03.12.2011
 */
public abstract class SimpleAsyncGameActivity extends BaseGameActivity {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	public abstract void onCreateResourcesAsync(final IProgressListener pProgressListener) throws Exception; // TODO Rename
	public abstract Scene onCreateSceneAsync(final IProgressListener pProgressListener) throws Exception; // TODO Rename
	public abstract void onPopulateSceneAsync(final Scene pScene, IProgressListener pProgressListener) throws Exception; // TODO Rename

	@Override
	public void onCreateResources(final OnCreateResourcesCallback pOnCreateResourcesCallback) {
		this.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				ActivityUtils.doProgressAsync(org.andengine.ui.activity.SimpleAsyncGameActivity.this, "Loading Resources...", android.R.drawable.ic_menu_rotate, new ProgressCallable<Void>() {
					@Override
					public Void call(final IProgressListener pProgressListener) throws Exception {
						org.andengine.ui.activity.SimpleAsyncGameActivity.this.onCreateResourcesAsync(pProgressListener);

						pProgressListener.onProgressChanged(100);

						pOnCreateResourcesCallback.onCreateResourcesFinished();

						return null;
					}
				}, new Callback<Void>() {
					@Override
					public void onCallback(final Void pCallbackValue) {
						/* Nothing. */
					}
				});
			}
		});
	}

	@Override
	public void onCreateScene(final OnCreateSceneCallback pOnCreateSceneCallback) {
		this.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				ActivityUtils.doProgressAsync(org.andengine.ui.activity.SimpleAsyncGameActivity.this, "Loading Scene...", android.R.drawable.ic_menu_rotate, new ProgressCallable<Void>() {
					@Override
					public Void call(final IProgressListener pProgressListener) throws Exception {
						final Scene scene = org.andengine.ui.activity.SimpleAsyncGameActivity.this.onCreateSceneAsync(pProgressListener);

						pProgressListener.onProgressChanged(100);

						pOnCreateSceneCallback.onCreateSceneFinished(scene);

						return null;
					}
				}, new Callback<Void>() {
					@Override
					public void onCallback(final Void pCallbackValue) {
						/* Nothing. */
					}
				});
			}
		});
	}

	@Override
	public void onPopulateScene(final Scene pScene, final OnPopulateSceneCallback pOnPopulateSceneCallback) {
		this.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				ActivityUtils.doProgressAsync(org.andengine.ui.activity.SimpleAsyncGameActivity.this, "Populating Scene...", android.R.drawable.ic_menu_rotate, new ProgressCallable<Void>() {
					@Override
					public Void call(final IProgressListener pProgressListener) throws Exception {
						org.andengine.ui.activity.SimpleAsyncGameActivity.this.onPopulateSceneAsync(pScene, pProgressListener);

						pProgressListener.onProgressChanged(100);

						pOnPopulateSceneCallback.onPopulateSceneFinished();

						return null;
					}
				}, new Callback<Void>() {
					@Override
					public void onCallback(final Void pCallbackValue) {
						/* Nothing. */
					}
				});
			}
		});
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
