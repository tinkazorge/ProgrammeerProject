package org.andengine.entity.sprite.batch.vbo.andengine.opengl.vbo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.locks.ReentrantLock;

import org.andengine.opengl.util.BufferUtils;
import org.andengine.opengl.vbo.*;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.opengl.vbo.attribute.VertexBufferObjectAttributes;

/**
 * Compared to {@link ZeroMemoryVertexBufferObject}, all {@link org.andengine.opengl.vbo.SharedMemoryVertexBufferObject}s share a single {@link ByteBuffer} which is used by whichever {@link org.andengine.opengl.vbo.SharedMemoryVertexBufferObject} instance is currently buffering data,
 * at the cost of expensive data buffering (<b>up to <u>5x</u> slower!</b>) and a little synchronization overhead.
 * <p/>
 * Usually a {@link org.andengine.opengl.vbo.SharedMemoryVertexBufferObject} is preferred to a {@link ZeroMemoryVertexBufferObject} when the following conditions need to be met:
 * <ol>
 * <li>Minimum amount of runtime GarbageCollector activity.</li>
 * </ol>
 * <p/>
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @author Greg Haynes
 * @since 19:22:13 - 10.02.2012
 */
public abstract class SharedMemoryVertexBufferObject extends ZeroMemoryVertexBufferObject {
	// ===========================================================
	// Constants
	// ===========================================================

	private static ReentrantLock sSharedByteBufferLock = new ReentrantLock(true);
	private static ByteBuffer sSharedByteBuffer;

	public static int getSharedByteBufferByteCapacity() {
		final int byteCapacity;
		try {
			org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBufferLock.lock();

			final ByteBuffer sharedByteBuffer = org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBuffer;
			if (sharedByteBuffer == null) {
				byteCapacity = 0;
			} else {
				byteCapacity = sharedByteBuffer.capacity();
			}
		} finally {
			org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBufferLock.unlock();
		}

		return byteCapacity;
	}

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public SharedMemoryVertexBufferObject(final VertexBufferObjectManager pVertexBufferObjectManager, final int pCapacity, final DrawType pDrawType, final VertexBufferObjectAttributes pVertexBufferObjectAttributes) {
		super(pVertexBufferObjectManager, pCapacity, pDrawType, false, pVertexBufferObjectAttributes);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public void dispose() {
		super.dispose();

		try {
			org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBufferLock.lock();

			if (org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBuffer != null) {
				BufferUtils.freeDirectByteBuffer(org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBuffer);

				org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBuffer = null;
			}
		} finally {
			org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBufferLock.unlock();
		}
	}

	@Override
	protected ByteBuffer aquireByteBuffer() {
		org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBufferLock.lock();

		final int byteCapacity = this.getByteCapacity();

		if (org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBuffer == null || org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBuffer.capacity() < byteCapacity) {
			if (org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBuffer != null) {
				BufferUtils.freeDirectByteBuffer(org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBuffer);
			}

			org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBuffer = BufferUtils.allocateDirectByteBuffer(byteCapacity);
			org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBuffer.order(ByteOrder.nativeOrder());
		}

		org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBuffer.limit(byteCapacity);

		return org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBuffer;
	}

	@Override
	protected void releaseByteBuffer(final ByteBuffer byteBuffer) {
		org.andengine.opengl.vbo.SharedMemoryVertexBufferObject.sSharedByteBufferLock.unlock();
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
