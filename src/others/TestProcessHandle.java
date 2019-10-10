package others;

import java.io.IOException;
import java.time.ZoneId;

/**
 * Java9 ProcessBuilder、ProcessHandle获取进程信息练习
 */
public class TestProcessHandle {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("I:\\ProgramFiles\\WeChat\\WeChat.exe");
        try {
            Process p = pb.start();
            ProcessHandle.Info info = p.info();
            System.out.printf("Process id : %s%n", p.pid());
            System.out.printf("Command name : %s%n", info.command().orElse("NoCommand"));
            System.out.printf("Start time : %s%n", info.startInstant().map(i -> i.atZone(ZoneId.systemDefault())
                    .toLocalDateTime().toString()).orElse("No"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
