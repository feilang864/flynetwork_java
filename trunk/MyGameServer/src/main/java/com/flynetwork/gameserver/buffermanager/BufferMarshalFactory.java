/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.flynetwork.gameserver.buffermanager;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 *
 * @author Administrator
 */
public class BufferMarshalFactory implements ProtocolCodecFactory {

        @Override
        public ProtocolEncoder getEncoder(IoSession is) throws Exception {
            return new BufferMarshalEncoder();
        }

        @Override
        public ProtocolDecoder getDecoder(IoSession is) throws Exception {
            return new BufferMarshalDecoder();
        }
    
}
