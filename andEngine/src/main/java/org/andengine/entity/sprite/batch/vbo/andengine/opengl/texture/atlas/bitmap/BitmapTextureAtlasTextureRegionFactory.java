package org.andengine.entity.sprite.batch.vbo.andengine.opengl.texture.atlas.bitmap;


import java.io.IOException;

import org.andengine.opengl.texture.atlas.bitmap.*;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.AssetBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.bitmap.source.ResourceBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.BuildableTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.util.exception.AndEngineRuntimeException;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;


/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 18:15:14 - 09.03.2010
 */
public final class BitmapTextureAtlasTextureRegionFactory {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private static String sAssetBasePath = "";

	// ===========================================================
	// Constructors
	// ===========================================================

	private BitmapTextureAtlasTextureRegionFactory() {

	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	/**
	 * @param pAssetBasePath must end with '<code>/</code>' or have <code>.length() == 0</code>.
	 */
	public static void setAssetBasePath(final String pAssetBasePath) {
		if (pAssetBasePath.endsWith("/") || pAssetBasePath.length() == 0) {
			org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.sAssetBasePath = pAssetBasePath;
		} else {
			throw new IllegalArgumentException("pAssetBasePath must end with '/' or be length zero.");
		}
	}

	public static String getAssetBasePath() {
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.sAssetBasePath;
	}

	public static void reset() {
		org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("");
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Methods using BitmapTexture
	// ===========================================================

	public static TextureRegion createFromAsset(final org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas pBitmapTextureAtlas, final Context pContext, final String pAssetPath, final int pTextureX, final int pTextureY) {
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createFromAsset(pBitmapTextureAtlas, pContext.getAssets(), pAssetPath, pTextureX, pTextureY);
	}

	public static TextureRegion createFromAsset(final org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas pBitmapTextureAtlas, final AssetManager pAssetManager, final String pAssetPath, final int pTextureX, final int pTextureY) {
		final IBitmapTextureAtlasSource bitmapTextureAtlasSource = AssetBitmapTextureAtlasSource.create(pAssetManager, org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.sAssetBasePath + pAssetPath);
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createFromSource(pBitmapTextureAtlas, bitmapTextureAtlasSource, pTextureX, pTextureY);
	}

	public static TiledTextureRegion createTiledFromAsset(final org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas pBitmapTextureAtlas, final Context pContext, final String pAssetPath, final int pTextureX, final int pTextureY, final int pTileColumns, final int pTileRows) {
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(pBitmapTextureAtlas, pContext.getAssets(), pAssetPath, pTextureX, pTextureY, pTileColumns, pTileRows);
	}

	public static TiledTextureRegion createTiledFromAsset(final org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas pBitmapTextureAtlas, final AssetManager pAssetManager, final String pAssetPath, final int pTextureX, final int pTextureY, final int pTileColumns, final int pTileRows) {
		final IBitmapTextureAtlasSource bitmapTextureAtlasSource = AssetBitmapTextureAtlasSource.create(pAssetManager, org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.sAssetBasePath + pAssetPath);
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createTiledFromSource(pBitmapTextureAtlas, bitmapTextureAtlasSource, pTextureX, pTextureY, pTileColumns, pTileRows);
	}


	public static TextureRegion createFromResource(final org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas pBitmapTextureAtlas, final Context pContext, final int pDrawableResourceID, final int pTextureX, final int pTextureY) {
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createFromResource(pBitmapTextureAtlas, pContext.getResources(), pDrawableResourceID, pTextureX, pTextureY);
	}

	public static TextureRegion createFromResource(final org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas pBitmapTextureAtlas, final Resources pResources, final int pDrawableResourceID, final int pTextureX, final int pTextureY) {
		final IBitmapTextureAtlasSource bitmapTextureAtlasSource = ResourceBitmapTextureAtlasSource.create(pResources, pDrawableResourceID);
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createFromSource(pBitmapTextureAtlas, bitmapTextureAtlasSource, pTextureX, pTextureY);
	}

	public static TiledTextureRegion createTiledFromResource(final org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas pBitmapTextureAtlas, final Context pContext, final int pDrawableResourceID, final int pTextureX, final int pTextureY, final int pTileColumns, final int pTileRows) {
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createTiledFromResource(pBitmapTextureAtlas, pContext.getResources(), pDrawableResourceID, pTextureX, pTextureY, pTileColumns, pTileRows);
	}

	public static TiledTextureRegion createTiledFromResource(final org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas pBitmapTextureAtlas, final Resources pResources, final int pDrawableResourceID, final int pTextureX, final int pTextureY, final int pTileColumns, final int pTileRows) {
		final IBitmapTextureAtlasSource bitmapTextureAtlasSource = ResourceBitmapTextureAtlasSource.create(pResources, pDrawableResourceID);
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createTiledFromSource(pBitmapTextureAtlas, bitmapTextureAtlasSource, pTextureX, pTextureY, pTileColumns, pTileRows);
	}


	public static TextureRegion createFromSource(final org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas pBitmapTextureAtlas, final IBitmapTextureAtlasSource pBitmapTextureAtlasSource, final int pTextureX, final int pTextureY) {
		return TextureRegionFactory.createFromSource(pBitmapTextureAtlas, pBitmapTextureAtlasSource, pTextureX, pTextureY);
	}

	public static TiledTextureRegion createTiledFromSource(final BitmapTextureAtlas pBitmapTextureAtlas, final IBitmapTextureAtlasSource pBitmapTextureAtlasSource, final int pTextureX, final int pTextureY, final int pTileColumns, final int pTileRows) {
		return TextureRegionFactory.createTiledFromSource(pBitmapTextureAtlas, pBitmapTextureAtlasSource, pTextureX, pTextureY, pTileColumns, pTileRows);
	}

	// ===========================================================
	// Methods using BuildableTexture
	// ===========================================================

	public static TextureRegion createFromAsset(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final Context pContext, final String pAssetPath) {
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createFromAsset(pBuildableBitmapTextureAtlas, pContext.getAssets(), pAssetPath);
	}

	public static TextureRegion createFromAsset(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final AssetManager pAssetManager, final String pAssetPath) {
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createFromAsset(pBuildableBitmapTextureAtlas, pAssetManager, pAssetPath, false);
	}

	public static TextureRegion createFromAsset(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final Context pContext, final String pAssetPath, final boolean pRotated) {
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createFromAsset(pBuildableBitmapTextureAtlas, pContext.getAssets(), pAssetPath, pRotated);
	}

	public static TextureRegion createFromAsset(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final AssetManager pAssetManager, final String pAssetPath, final boolean pRotated) {
		final IBitmapTextureAtlasSource bitmapTextureAtlasSource = AssetBitmapTextureAtlasSource.create(pAssetManager, org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.sAssetBasePath + pAssetPath);
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createFromSource(pBuildableBitmapTextureAtlas, bitmapTextureAtlasSource, pRotated);
	}

	public static TiledTextureRegion createTiledFromAsset(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final Context pContext, final String pAssetPath, final int pTileColumns, final int pTileRows) {
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(pBuildableBitmapTextureAtlas, pContext.getAssets(), pAssetPath, pTileColumns, pTileRows);
	}

	public static TiledTextureRegion createTiledFromAsset(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final AssetManager pAssetManager, final String pAssetPath, final int pTileColumns, final int pTileRows) {
		final IBitmapTextureAtlasSource bitmapTextureAtlasSource = AssetBitmapTextureAtlasSource.create(pAssetManager, org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.sAssetBasePath + pAssetPath);
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createTiledFromSource(pBuildableBitmapTextureAtlas, bitmapTextureAtlasSource, pTileColumns, pTileRows);
	}

	public static TextureRegion createFromResource(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final Context pContext, final int pDrawableResourceID) {
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createFromResource(pBuildableBitmapTextureAtlas, pContext.getResources(), pDrawableResourceID);
	}

	public static TextureRegion createFromResource(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final Resources pResources, final int pDrawableResourceID) {
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createFromResource(pBuildableBitmapTextureAtlas, pResources, pDrawableResourceID, false);
	}

	public static TextureRegion createFromResource(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final Context pContext, final int pDrawableResourceID, final boolean pRotated) {
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createFromResource(pBuildableBitmapTextureAtlas, pContext.getResources(), pDrawableResourceID, pRotated);
	}

	public static TextureRegion createFromResource(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final Resources pResources, final int pDrawableResourceID, final boolean pRotated) {
		final IBitmapTextureAtlasSource bitmapTextureAtlasSource = ResourceBitmapTextureAtlasSource.create(pResources, pDrawableResourceID);
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createFromSource(pBuildableBitmapTextureAtlas, bitmapTextureAtlasSource, pRotated);
	}

	public static TiledTextureRegion createTiledFromResource(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final Context pContext, final int pDrawableResourceID, final int pTileColumns, final int pTileRows) {
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createTiledFromResource(pBuildableBitmapTextureAtlas, pContext.getResources(), pDrawableResourceID, pTileColumns, pTileRows);
	}

	public static TiledTextureRegion createTiledFromResource(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final Resources pResources, final int pDrawableResourceID, final int pTileColumns, final int pTileRows) {
		final IBitmapTextureAtlasSource bitmapTextureAtlasSource = ResourceBitmapTextureAtlasSource.create(pResources, pDrawableResourceID);
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createTiledFromSource(pBuildableBitmapTextureAtlas, bitmapTextureAtlasSource, pTileColumns, pTileRows);
	}


	public static TextureRegion createFromSource(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final IBitmapTextureAtlasSource pBitmapTextureAtlasSource) {
		return org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createFromSource(pBuildableBitmapTextureAtlas, pBitmapTextureAtlasSource, false);
	}

	public static TextureRegion createFromSource(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final IBitmapTextureAtlasSource pBitmapTextureAtlasSource, final boolean pRotated) {
		return BuildableTextureAtlasTextureRegionFactory.createFromSource(pBuildableBitmapTextureAtlas, pBitmapTextureAtlasSource, pRotated);
	}

	public static TiledTextureRegion createTiledFromSource(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final IBitmapTextureAtlasSource pBitmapTextureAtlasSource, final int pTileColumns, final int pTileRows) {
		return BuildableTextureAtlasTextureRegionFactory.createTiledFromSource(pBuildableBitmapTextureAtlas, pBitmapTextureAtlasSource, pTileColumns, pTileRows);
	}

	/**
	 * Loads all files from a given assets directory (in alphabetical order) as consecutive tiles of an {@link TiledTextureRegion}.
	 *
	 * @param pBuildableBitmapTextureAtlas
	 * @param pAssetManager
	 * @param pAssetSubdirectory to load all files from "gfx/flowers" put "flowers" here (assuming, that you've used {@link org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory#setAssetBasePath(String)} with "gfx/" before.)
	 * @return
	 */
	public static TiledTextureRegion createTiledFromAssetDirectory(final BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, final AssetManager pAssetManager, final String pAssetSubdirectory) {
		final String[] files;
		try {
			files = pAssetManager.list(org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.sAssetBasePath + pAssetSubdirectory);
		} catch (final IOException e) {
			throw new AndEngineRuntimeException("Listing assets subdirectory: '" + org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.sAssetBasePath + pAssetSubdirectory + "' failed. Does it exist?", e);
		}
		final int fileCount = files.length;
		final TextureRegion[] textures = new TextureRegion[fileCount];

		for (int i = 0; i < fileCount; i++) {
			final String assetPath = pAssetSubdirectory + "/" + files[i];
			textures[i] = org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory.createFromAsset(pBuildableBitmapTextureAtlas, pAssetManager, assetPath);
		}

		return new TiledTextureRegion(pBuildableBitmapTextureAtlas, textures);
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
