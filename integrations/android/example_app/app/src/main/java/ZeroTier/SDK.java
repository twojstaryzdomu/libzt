package ZeroTier;

import java.net.SocketAddress;

public class SDK {

    // Socket families
    public int AF_UNIX = 1;
    public int AF_INET = 2;

    // Socket types
    public int SOCK_STREAM = 1;
    public int SOCK_DGRAM = 2;

    // Loads JNI code
    static { System.loadLibrary("ZeroTierOneJNI"); }

    // ZeroTier service controls
    public native void startOneService(String homeDir);
    public native void joinNetwork(String nwid);
    public native void leaveNetwork(String nwid);
    public native boolean isRunning();

    // Direct-call API
    // --- These calls skip the intercept and interface directly via the RPC mechanism ---
    public native int ztjniSocket(int family, int type, int protocol);
    public native int ztjniConnect(int fd, String addr, int port);
    public native int ztjniBind(int fd, String addr, int port);
    public native int ztjniAccept4(int fd, String addr, int port);
    public native int ztjniAccept(int fd, String addr, int port, int flags);
    public native int ztjniListen(int fd, int backlog);
    //public native int ztjniGetsockopt(int fd, int type, int protocol);
    //public native int ztjniSetsockopt(int fd, int type, int protocol);
    //public native int ztjniGetsockname(int fd, int type, int protocol);
    public native int ztjniClose(int fd);
}