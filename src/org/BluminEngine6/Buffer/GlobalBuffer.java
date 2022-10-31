package org.BluminEngine6.Buffer;

import org.apache.commons.lang3.SerializationUtils;

import java.lang.reflect.Array;
import java.nio.*;
import java.util.Arrays;

public class GlobalBuffer{
    private ByteBuffer byteBuffer;
    private IntBuffer intBuffer;
    private FloatBuffer floatBuffer;
    private ShortBuffer shortBuffer;
    private CharBuffer charBuffer;

    public BufferType type;


    public GlobalBuffer(BufferType type, Object[] data) {
        switch (type) {
            case Byte:
                byteBuffer = ByteBuffer.allocate(data.length);
                byte[] bytearray = new byte[data.length];
                System.arraycopy(data, 0, bytearray, 0, data.length);
                byteBuffer.put(bytearray);
                byteBuffer.flip();
            break;
            case Short:
                shortBuffer = ShortBuffer.allocate(data.length);
                short[] shortarray = new short[data.length];
                System.arraycopy(data, 0, shortarray, 0, data.length);
                shortBuffer.put(shortarray);
                shortBuffer.flip();
            break;
            case Int:
                intBuffer = IntBuffer.allocate(data.length);
                int[] inta = new int[data.length];
                System.arraycopy(data, 0, inta, 0, data.length);
                intBuffer.put(inta);
                intBuffer.flip();
                break;
            case Float:
                floatBuffer = FloatBuffer.allocate(data.length);
                float[] floata = new float[data.length];
                System.arraycopy(data, 0, floata, 0, data.length);
                floatBuffer.put(floata);
                floatBuffer.flip();
                break;
            case String:
                charBuffer = CharBuffer.allocate(data.length);
                char[] chara = new char[data.length];
                System.arraycopy(data, 0, chara, 0, data.length);
                charBuffer.put(chara);
                charBuffer.flip();
                break;
        }
        this.type = type;
    }


    public <t extends Buffer> GlobalBuffer(BufferType type, t data) {
        switch (type) {
            case Byte:
                byteBuffer = (ByteBuffer) data;
                break;
            case Short:
                shortBuffer = (ShortBuffer) data;
            break;
            case Int:
                intBuffer = (IntBuffer) data;
            break;
            case Float:
                floatBuffer = (FloatBuffer) data;
            break;
            case String:
                charBuffer = (CharBuffer) data;
            break;
        }
        this.type = type;
    }

    public <t extends Buffer> t GetBuffer() {
        return GetBuffer(type);
    }

    public <t extends Buffer> t GetBuffer(BufferType type){
        switch (type) {
            case Byte:
                return (t) byteBuffer;
            case Short:
                return (t) shortBuffer;
        }
        return null;
    }


}
