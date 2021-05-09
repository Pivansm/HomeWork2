package sbp.io;

import java.io.*;
import java.util.Date;

public class MyIOExample {
    /**
     * Создать объект класса {@link java.io.File}, проверить существование и чем является (фалй или директория).
     * Если сущность существует, то вывести в консоль информацию:
     *      - абсолютный путь
     *      - родительский путь
     * Если сущность является файлом, то вывести в консоль:
     *      - размер
     *      - время последнего изменения
     * Необходимо использовать класс {@link java.io.File}
     * @param fileName - имя файла
     * @return - true, если файл успешно создан
     */
    public boolean workWithFile(String fileName)
    {
        /*
        ...
         */

        File file = new File(fileName);
        if(file.exists()) {
            System.out.println("абсолютный путь " + file.getAbsolutePath());
            System.out.println("родительский путь " + file.getParent());
            if(file.isFile()) {
                System.out.println("размер "  + file.length());
                System.out.println(" время последнего изменения " + new Date(file.lastModified()));
            }
            return true;
        }
        return false;
    }

    /**
     * Метод должен создавать копию файла
     * Необходимо использовать IO классы {@link java.io.FileInputStream} и {@link java.io.FileOutputStream}
     * @param sourceFileName - имя исходного файла
     * @param destinationFileName - имя копии файла
     * @return - true, если файл успешно скопирован
     */
    public boolean copyFile(String sourceFileName, String destinationFileName)
    {
        /*
        ...

         */
        try(InputStream in = new FileInputStream(sourceFileName); OutputStream out = new FileOutputStream(destinationFileName))
        {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* try
        {
            InputStream in = new FileInputStream(sourceFileName);
            OutputStream out = new FileOutputStream(destinationFileName);

            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }

            in.close();
            out.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        } */
        return false;
    }

    /**
     * Метод должен создавать копию файла
     * Необходимо использовать IO классы {@link java.io.BufferedInputStream} и {@link java.io.BufferedOutputStream}
     * @param sourceFileName - имя исходного файла
     * @param destinationFileName - имя копии файла
     * @return - true, если файл успешно скопирован
     */
    public boolean copyBufferedFile(String sourceFileName, String destinationFileName)
    {
        /*
        ...
         */

        try
        {
            BufferedInputStream bufferedInput = new BufferedInputStream(new FileInputStream(sourceFileName));
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(new FileOutputStream(destinationFileName));

            byte[] buff = new byte[1024];
            int len;
            while ((len = bufferedInput.read(buff)) > 0) {
                bufferedOutput.write(buff, 0, len);
            }

            bufferedOutput.flush();

            bufferedInput.close();
            bufferedOutput.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Метод должен создавать копию файла
     * Необходимо использовать IO классы {@link java.io.FileReader} и {@link java.io.FileWriter}
     * @param sourceFileName - имя исходного файла
     * @param destinationFileName - имя копии файла
     * @return - true, если файл успешно скопирован
     */
    public boolean copyFileWithReaderAndWriter(String sourceFileName, String destinationFileName)
    {
        /*
        ...
         */
        try(
        FileReader fileReader = new FileReader(sourceFileName);
        FileWriter fileWriter = new FileWriter(destinationFileName)) {
            int l;
            while ((l = fileReader.read()) != -1) {
                fileWriter.write(l);
            }
            fileReader.close();
            fileWriter.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}
