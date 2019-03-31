package com.hacker.framework.net;

import java.io.IOException;

/**
 * Created by hacker on 2019/3/31 0031.
 */
public interface ProtocolService {

    NetResponse get(NetRequest netRequest) throws IOException;

    NetResponse post(NetRequest netRequest) throws IOException;
}
