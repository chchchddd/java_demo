import java.io.*;
/**
 * �ļ�����StreamOperator.java
 * �������������������ļ�
 */
public class StreamOperator {
    private final int BUF_SIZE = 10; //Ϊ��ʾЧ��������ѻ������õú�С������һ��Ϊ1024�ı���

    //-----------------�ֽ����ļ����Ʒ���---------------//
    void CopyFileByByteStream(String sFileName,String dFileName) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        long byteStart = System.currentTimeMillis();//��ȡϵͳ��ǰʱ���
        try {
            fis = new FileInputStream(sFileName);
            fos = new FileOutputStream(dFileName);

            int len = 0;

            byte[] byteArray = new byte[BUF_SIZE];

            while ((len = fis.read(byteArray))>0) {
                fos.write(byteArray,0,len);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                fis.close();
            if (fos != null)
                fos.close();

            long byteEnd = System.currentTimeMillis();
            System.out.println("�ֽ��������ļ���ϣ�������"+(byteEnd-byteStart)+"���롣");
        }

    }

    //-----------------�ֽ���+�������ļ����Ʒ���---------------//
    void CopyFileByByteBufferedStream(String sFileName,String dFileName) throws IOException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        long startTime = System.currentTimeMillis();
        try {
            bis = new BufferedInputStream(new FileInputStream(sFileName));
            bos = new BufferedOutputStream(new FileOutputStream(dFileName));

            int len = 0;
            byte[] bufArray = new byte[BUF_SIZE];
            while ((len = bis.read(bufArray))>0) {
                bos.write(bufArray,0,len);
            }
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();

            long endTime = System.currentTimeMillis();
            System.out.println("�ֽ���+�����������ļ���ϣ�������"+(endTime-startTime)+"���롣");
        }
    }

    //-----------------�ַ����ļ����Ʒ���---------------//
    void CopyFileByCharStream(String sFileName,String dFileName) throws IOException {
        InputStreamReader reader = null;
        OutputStreamWriter writer = null;

        //FileReader fileReader = null;
        //FileWriter fileWriter = null;

        long startTime = System.currentTimeMillis();
        try {
            String charsetName = getFileCharsetName(sFileName);
            reader = new InputStreamReader(new FileInputStream(sFileName),charsetName);
            writer = new OutputStreamWriter(new FileOutputStream(dFileName),charsetName);

            //fileReader = new FileReader(sFileName);
            //fileWriter = new FileWriter(dFileName);

            int len = 0;
            char[] charArray = new char[BUF_SIZE];
            while ((len = reader.read(charArray))>0) {
                writer.write(charArray,0,len);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                reader.close();
            if (writer != null)
                writer.close();
            long endTime = System.currentTimeMillis();
            System.out.println("�ַ��������ļ���ϣ�������"+(endTime-startTime)+"���롣");
        }
    }

    //-----------------�ַ���+�������ļ����Ʒ���---------------//
    void CopyFileByCharBufferedStream(String sFileName,String dFileName) throws IOException {
        InputStreamReader reader = null;
        OutputStreamWriter writer = null;

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        long startTime = System.currentTimeMillis();
        try {
            String charsetName = getFileCharsetName(sFileName);
            reader = new InputStreamReader(new FileInputStream(sFileName),charsetName);
            writer = new OutputStreamWriter(new FileOutputStream(dFileName),charsetName);

            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);

            int len = 0;
            char[] charArray = new char[BUF_SIZE];
            while ((len = bufferedReader.read(charArray))>0) {
                bufferedWriter.write(charArray,0,len);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null)
                bufferedReader.close();
            if (bufferedWriter != null)
                bufferedWriter.close();
            if (reader != null)
                reader.close();
            if (writer != null)
                writer.close();
            long endTime = System.currentTimeMillis();
            System.out.println("�ַ���+�����������ļ���ϣ�������"+(endTime-startTime)+"���롣");
        }
    }

    /**
     * ��ȡ�ı��ļ��ı����ʽ
     * @param fileName :file
     * @return �ļ������ʽ
     * @throws IOException
     */
    public static String getFileCharsetName(String fileName) throws IOException {
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();
        String code = null;

        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }

        return code;
    }
}
