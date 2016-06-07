package org.andengine.entity.sprite.batch.vbo.andengine.util.algorithm.collision;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.IEntity;
import org.andengine.entity.primitive.Line;
import org.andengine.util.Constants;
import org.andengine.util.adt.transformation.Transformation;
import org.andengine.util.algorithm.collision.*;
import org.andengine.util.algorithm.collision.LineCollisionChecker;
import org.andengine.util.math.MathUtils;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 11:50:19 - 11.03.2010
 */
public final class EntityCollisionChecker {
	// ===========================================================
	// Constants
	// ===========================================================

	public static final int RECTANGULARSHAPE_VERTEX_COUNT = 4;

	private static final float[] VERTICES_CONTAINS_TMP = new float[2 * org.andengine.util.algorithm.collision.EntityCollisionChecker.RECTANGULARSHAPE_VERTEX_COUNT];
	private static final float[] VERTICES_COLLISION_TMP_A = new float[2 * org.andengine.util.algorithm.collision.EntityCollisionChecker.RECTANGULARSHAPE_VERTEX_COUNT];
	private static final float[] VERTICES_COLLISION_TMP_B = new float[2 * org.andengine.util.algorithm.collision.EntityCollisionChecker.RECTANGULARSHAPE_VERTEX_COUNT];

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	private EntityCollisionChecker() {

	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	public static boolean checkContains(final float pLocalX, final float pLocalY, final float pLocalWidth, final float pLocalHeight, final Transformation pLocalToSceneTransformation, final float pX, final float pY) {
		org.andengine.util.algorithm.collision.EntityCollisionChecker.fillVertices(pLocalX, pLocalY, pLocalWidth, pLocalHeight, pLocalToSceneTransformation, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_CONTAINS_TMP);
		return BaseCollisionChecker.checkContains(org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_CONTAINS_TMP, org.andengine.util.algorithm.collision.EntityCollisionChecker.RECTANGULARSHAPE_VERTEX_COUNT, pX, pY);
	}

	public static boolean checkContains(final IEntity pEntity, final float pLocalWidth, final float pLocalHeight, final float pX, final float pY) {
		org.andengine.util.algorithm.collision.EntityCollisionChecker.fillVertices(pEntity.getX(), pEntity.getY(), pLocalWidth, pLocalHeight, pEntity.getLocalToSceneTransformation(), org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_CONTAINS_TMP);
		return BaseCollisionChecker.checkContains(org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_CONTAINS_TMP, org.andengine.util.algorithm.collision.EntityCollisionChecker.RECTANGULARSHAPE_VERTEX_COUNT, pX, pY);
	}

	public static boolean checkContains(final IEntity pEntity, final float pX, final float pY) {
		org.andengine.util.algorithm.collision.EntityCollisionChecker.fillVertices(pEntity, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_CONTAINS_TMP);
		return BaseCollisionChecker.checkContains(org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_CONTAINS_TMP, org.andengine.util.algorithm.collision.EntityCollisionChecker.RECTANGULARSHAPE_VERTEX_COUNT, pX, pY);
	}

	public static boolean isVisible(final Camera pCamera, final IEntity pEntity) {
		org.andengine.util.algorithm.collision.EntityCollisionChecker.fillVertices(pCamera, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_A);
		org.andengine.util.algorithm.collision.EntityCollisionChecker.fillVertices(pEntity, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_B);

		return BaseCollisionChecker.checkCollision(org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_A, org.andengine.util.algorithm.collision.EntityCollisionChecker.RECTANGULARSHAPE_VERTEX_COUNT, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_B, org.andengine.util.algorithm.collision.EntityCollisionChecker.RECTANGULARSHAPE_VERTEX_COUNT);
	}

	public static boolean isVisible(final Camera pCamera, final float pX, final float pY, final float pWidth, final float pHeight, final Transformation pLocalToSceneTransformation) {
		org.andengine.util.algorithm.collision.EntityCollisionChecker.fillVertices(pCamera, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_A);
		org.andengine.util.algorithm.collision.EntityCollisionChecker.fillVertices(pX, pY, pWidth, pHeight, pLocalToSceneTransformation, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_B);

		return BaseCollisionChecker.checkCollision(org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_A, org.andengine.util.algorithm.collision.EntityCollisionChecker.RECTANGULARSHAPE_VERTEX_COUNT, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_B, org.andengine.util.algorithm.collision.EntityCollisionChecker.RECTANGULARSHAPE_VERTEX_COUNT);
	}

	public static boolean isVisible(final Camera pCamera, final Line pLine) {
		org.andengine.util.algorithm.collision.EntityCollisionChecker.fillVertices(pCamera, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_A);
		org.andengine.util.algorithm.collision.LineCollisionChecker.fillVertices(pLine, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_B);

		return BaseCollisionChecker.checkCollision(org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_A, org.andengine.util.algorithm.collision.EntityCollisionChecker.RECTANGULARSHAPE_VERTEX_COUNT, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_B, org.andengine.util.algorithm.collision.LineCollisionChecker.LINE_VERTEX_COUNT);
	}

	public static boolean checkCollision(final IEntity pEntityA, final IEntity pEntityB) {
		org.andengine.util.algorithm.collision.EntityCollisionChecker.fillVertices(pEntityA, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_A);
		org.andengine.util.algorithm.collision.EntityCollisionChecker.fillVertices(pEntityB, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_B);

		return BaseCollisionChecker.checkCollision(org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_A, org.andengine.util.algorithm.collision.EntityCollisionChecker.RECTANGULARSHAPE_VERTEX_COUNT, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_B, org.andengine.util.algorithm.collision.EntityCollisionChecker.RECTANGULARSHAPE_VERTEX_COUNT);
	}

	public static boolean checkCollision(final IEntity pEntity, final Line pLine) {
		org.andengine.util.algorithm.collision.EntityCollisionChecker.fillVertices(pEntity, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_A);
		org.andengine.util.algorithm.collision.LineCollisionChecker.fillVertices(pLine, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_B);

		return BaseCollisionChecker.checkCollision(org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_A, org.andengine.util.algorithm.collision.EntityCollisionChecker.RECTANGULARSHAPE_VERTEX_COUNT, org.andengine.util.algorithm.collision.EntityCollisionChecker.VERTICES_COLLISION_TMP_B, LineCollisionChecker.LINE_VERTEX_COUNT);
	}

	public static void fillVertices(final IEntity pEntity, final float[] pVertices) {
		org.andengine.util.algorithm.collision.EntityCollisionChecker.fillVertices(0, 0, pEntity.getWidth(), pEntity.getHeight(), pEntity.getLocalToSceneTransformation(), pVertices);
	}

	public static void fillVertices(final float pLocalX, final float pLocalY, final float pLocalWidth, final float pLocalHeight, final Transformation pLocalToSceneTransformation, final float[] pVertices) {
		final float localXMin = pLocalX;
		final float localXMax = pLocalX + pLocalWidth;
		final float localYMin = pLocalY;
		final float localYMax = pLocalY + pLocalHeight;

		pVertices[0 + Constants.VERTEX_INDEX_X] = localXMin;
		pVertices[0 + Constants.VERTEX_INDEX_Y] = localYMin;

		pVertices[2 + Constants.VERTEX_INDEX_X] = localXMax;
		pVertices[2 + Constants.VERTEX_INDEX_Y] = localYMin;

		pVertices[4 + Constants.VERTEX_INDEX_X] = localXMax;
		pVertices[4 + Constants.VERTEX_INDEX_Y] = localYMax;

		pVertices[6 + Constants.VERTEX_INDEX_X] = localXMin;
		pVertices[6 + Constants.VERTEX_INDEX_Y] = localYMax;

		pLocalToSceneTransformation.transform(pVertices);
	}

	private static void fillVertices(final Camera pCamera, final float[] pVertices) {
		pVertices[0 + Constants.VERTEX_INDEX_X] = pCamera.getXMin();
		pVertices[0 + Constants.VERTEX_INDEX_Y] = pCamera.getYMin();

		pVertices[2 + Constants.VERTEX_INDEX_X] = pCamera.getXMax();
		pVertices[2 + Constants.VERTEX_INDEX_Y] = pCamera.getYMin();

		pVertices[4 + Constants.VERTEX_INDEX_X] = pCamera.getXMax();
		pVertices[4 + Constants.VERTEX_INDEX_Y] = pCamera.getYMax();

		pVertices[6 + Constants.VERTEX_INDEX_X] = pCamera.getXMin();
		pVertices[6 + Constants.VERTEX_INDEX_Y] = pCamera.getYMax();

		MathUtils.rotateAroundCenter(pVertices, pCamera.getRotation(), pCamera.getCenterX(), pCamera.getCenterY());
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
