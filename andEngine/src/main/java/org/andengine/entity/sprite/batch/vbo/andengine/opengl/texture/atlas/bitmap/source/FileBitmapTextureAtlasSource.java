package org.andengine.entity.sprite.batch.vbo.andengine.opengl.texture.atlas.bitmap.source;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.source.BaseTextureAtlasSource;
import org.andengine.util.BitmapUtils;
import org.andengine.util.FileUtils;
import org.andengine.util.StreamUtils;
import org.andengine.util.debug.Debug;
import org.andengine.util.system.SystemUtils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Build;

/**
 *
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 16:39:22 - 10.08.2010
 */
public class FileBitmapTextureAtlasSource extends BaseTextureAtlasSource implements IBitmapTextureAtlasSource {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private final File mFile;

	// ===========================================================
	// Constructors
	// ===========================================================

	public static org.andengine.opengl.texture.atlas.bitmap.source.FileBitmapTextureAtlasSource create(final File pFile) {
		return org.andengine.opengl.texture.atlas.bitmap.source.FileBitmapTextureAtlasSource.create(pFile, 0, 0);
	}

	public static org.andengine.opengl.texture.atlas.bitmap.source.FileBitmapTextureAtlasSource create(final File pFile, final int pTextureX, final int pTextureY) {
		final BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
		decodeOptions.inJustDecodeBounds = true;

		InputStream in = null;
		try {
			in = new FileInputStream(pFile);
			BitmapFactory.decodeStream(in, null, decodeOptions);
		} catch (final IOException e) {
			Debug.e("Failed loading Bitmap in " + org.andengine.opengl.texture.atlas.bitmap.source.FileBitmapTextureAtlasSource.class.getSimpleName() + ". File: " + pFile, e);
		} finally {
			StreamUtils.close(in);
		}

		return new org.andengine.opengl.texture.atlas.bitmap.source.FileBitmapTextureAtlasSource(pFile, pTextureX, pTextureY, decodeOptions.outWidth, decodeOptions.outHeight);
	}

	public static org.andengine.opengl.texture.atlas.bitmap.source.FileBitmapTextureAtlasSource createFromInternalStorage(final Context pContext, final String pFilePath, final int pTextureX, final int pTextureY) {
		return org.andengine.opengl.texture.atlas.bitmap.source.FileBitmapTextureAtlasSource.create(new File(FileUtils.getAbsolutePathOnInternalStorage(pContext, pFilePath)), pTextureX, pTextureY);
	}

	public static org.andengine.opengl.texture.atlas.bitmap.source.FileBitmapTextureAtlasSource createFromExternalStorage(final Context pContext, final String pFilePath, final int pTextureX, final int pTextureY) {
		return org.andengine.opengl.texture.atlas.bitmap.source.FileBitmapTextureAtlasSource.create(new File(FileUtils.getAbsolutePathOnExternalStorage(pContext, pFilePath)), pTextureX, pTextureY);
	}

	FileBitmapTextureAtlasSource(final File pFile, final int pTextureX, final int pTextureY, final int pTextureWidth, final int pTextureHeight) {
		super(pTextureX, pTextureY, pTextureWidth, pTextureHeight);

		this.mFile = pFile;
	}

	@Override
	public org.andengine.opengl.texture.atlas.bitmap.source.FileBitmapTextureAtlasSource deepCopy() {
		return new org.andengine.opengl.texture.atlas.bitmap.source.FileBitmapTextureAtlasSource(this.mFile, this.mTextureX, this.mTextureY, this.mTextureWidth, this.mTextureHeight);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public Bitmap onLoadBitmap(final Config pBitmapConfig) {
		return this.onLoadBitmap(pBitmapConfig, false);
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public Bitmap onLoadBitmap(final Config pBitmapConfig, final boolean pMutable) {
		final BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
		decodeOptions.inPreferredConfig = pBitmapConfig;
		decodeOptions.inDither = false;

		if (pMutable && SystemUtils.isAndroidVersionOrHigher(Build.VERSION_CODES.HONEYCOMB)) {
			decodeOptions.inMutable = pMutable;
		}

		InputStream in = null;
		try {
			in = new FileInputStream(this.mFile);
			final Bitmap bitmap = BitmapFactory.decodeStream(in, null, decodeOptions);

			if (pMutable) {
				return BitmapUtils.ensureBitmapIsMutable(bitmap);
			} else {
				return bitmap;
			}
		} catch (final IOException e) {
			Debug.e("Failed loading Bitmap in " + this.getClass().getSimpleName() + ". File: " + this.mFile, e);
			return null;
		} finally {
			StreamUtils.close(in);
		}
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + this.mFile + ")";
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}