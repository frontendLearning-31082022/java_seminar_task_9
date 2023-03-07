package patterns;

import java.io.*;

public class Proxy {
    public static void ReaderTextFile() throws InterruptedException {
        ProxyReaderTextFile.main( null);
    }
}
class ProxyReaderTextFile extends Thread {
    private StringBuilder readedLines = new StringBuilder();
    File file;
    String startIndexOf = null;
    long index = 0;

    public ProxyReaderTextFile(File file) {
        this.file = file;
    }

    public ProxyReaderTextFile(File file, String textStartFrom) {
        this.file = file;
        startIndexOf = textStartFrom;
    }

    public void run() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(new ReverseLineInputStream(file)));

            while (true) {
                String line = in.readLine();
                if (line == null) {
                    break;
                }

                this.readedLines.insert(0, line + "\n");
                if (startIndexOf != null && line.indexOf(startIndexOf) > -1) {
                    index = this.readedLines.length() - line.indexOf(startIndexOf);
                    new String();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public String toString() {
        return getReaded();
    }

    private String getReaded() {
        if (this.readedLines.length() == 0) return "";

        while (true) {
            try {
                return String.valueOf(this.readedLines).substring((int) (this.readedLines.length() - this.index), this.readedLines.length());
            } catch (Exception r) {
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ProxyReaderTextFile proxyReaderTextFile = new ProxyReaderTextFile(new File("pathTo text file")
                , "<sup><span style=\"font-family:Courier New,Courier,monospace\">");
        ProxyReaderTextFile proxyReaderJustFile = new ProxyReaderTextFile(new File("pathTo text file"));
        proxyReaderTextFile.start();

        String text = "";
        while (true) {
            text = proxyReaderTextFile.toString();
            new String();
        }
    }


    private class ReverseLineInputStream extends InputStream {
        RandomAccessFile in;

        long currentLineStart = -1;
        long currentLineEnd = -1;
        long currentPos = -1;
        long lastPosInFile = -1;

        public ReverseLineInputStream(File file) throws FileNotFoundException {
            in = new RandomAccessFile(file, "r");
            currentLineStart = file.length();
            currentLineEnd = file.length();
            lastPosInFile = file.length() - 1;
            currentPos = currentLineEnd;
        }

        public void findPrevLine() throws IOException {

            currentLineEnd = currentLineStart;

            // There are no more lines, since we are at the beginning of the file and no lines.
            if (currentLineEnd == 0) {
                currentLineEnd = -1;
                currentLineStart = -1;
                currentPos = -1;
                return;
            }

            long filePointer = currentLineStart - 1;

            while (true) {
                filePointer--;

                // we are at start of file so this is the first line in the file.
                if (filePointer < 0) {
                    break;
                }

                in.seek(filePointer);
                int readByte = in.readByte();

                // We ignore last LF in file. search back to find the previous LF.
                if (readByte == 0xA && filePointer != lastPosInFile) {
                    break;
                }
            }
            // we want to start at pointer +1 so we are after the LF we found or at 0 the start of the file.
            currentLineStart = filePointer + 1;
            currentPos = currentLineStart;
        }

        public int read() throws IOException {

            if (currentPos < currentLineEnd) {
                in.seek(currentPos++);
                int readByte = in.readByte();
                return readByte;

            } else if (currentPos < 0) {
                return -1;
            } else {
                findPrevLine();
                return read();
            }
        }
    }

}