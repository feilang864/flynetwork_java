/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.main.msgaction;

import com.game.myconst.ConstHelper;
import com.game.proto.LoginMessage;
import com.game.proto.UserVersionMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class MsgAction {

    /**
     * 根据buffer 产生对应的对象实例
     *
     * @param msgID 消息ID
     * @param bytes 数据流
     * @return 返回实例对象
     */
    public static Message BufferNewMessage(int msgID, byte[] bytes) {
        Message protoMessage = null;
        try {
            switch (msgID) {
                case LoginMessage.Protos.ReqLogin_VALUE:
                    protoMessage = LoginMessage.ReqLoginMessage.newBuilder().mergeFrom(bytes).build();
                    break;
                case LoginMessage.Protos.ResLogin_VALUE:
                    protoMessage = LoginMessage.ResLoginMessage.newBuilder().mergeFrom(bytes).build();
                    break;
                case UserVersionMessage.Protos.ReqUserVersion_VALUE:
                    protoMessage = UserVersionMessage.ReqUserVersionMessage.newBuilder().mergeFrom(bytes).build();
                    break;
                case UserVersionMessage.Protos.ResUserVersion_VALUE:
                    protoMessage = UserVersionMessage.ResUserVersionMessage.newBuilder().mergeFrom(bytes).build();
                    break;
            }

        } catch (InvalidProtocolBufferException ex) {
            ConstHelper.AddLoggerInfo(ex.toString());
        }
        return protoMessage;
    }
}
