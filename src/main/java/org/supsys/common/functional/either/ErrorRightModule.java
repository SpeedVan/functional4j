package org.supsys.common.functional.either;

import java.util.stream.Stream;

public class ErrorRightModule {

    public static class ErrorMsg {
        public final Stream<ErrorMsg> errorMsgStream;
        public final String position;
        public final String msg;
        public ErrorMsg(Stream<ErrorMsg> errorMsgStream, String position, String msg){
            this.errorMsgStream = errorMsgStream;
            this.position = position;
            this.msg = msg;
        }
    }

    public static class ErrorRight extends Right<ErrorMsg> {

        public ErrorRight(Stream<ErrorMsg> errorMsgStream, String position, String msg) {
            super(new ErrorMsg(errorMsgStream, position, msg));
        }
    }

    public static class StrRight extends ErrorRight {
        public StrRight(String msg) {
            super(Stream.empty(), null, msg);
        }
    }

    public static class ErrorMessageRight extends ErrorRight {

        public ErrorMessageRight(Stream<ErrorMsg> errorMsgStream) {
            super(errorMsgStream, null, null);
        }
    }

    public static class ErrorPositionRight extends ErrorRight {

        public ErrorPositionRight(Stream<ErrorMsg> errorMsgStream, String position, String msg) {
            super(errorMsgStream, position, msg);
        }
    }

    public static ErrorMessageRight bind(ErrorRight a, ErrorRight b){
        return new ErrorMessageRight(Stream.concat(a.value.errorMsgStream, b.value.errorMsgStream));
    }

    public static ErrorMessageRight bind(Left a, ErrorRight b){
        return new ErrorMessageRight(b.value.errorMsgStream);
    }

//    private static ErrorOnlyMsgRight bind(Either a, Either b){
//        if(a.isLeft&&b.isLeft) return a;
//        else if(a.isLeft&&!b.isLeft) return b;
//        else if(!a.isLeft&&b.isLeft) return a;
//
//        else {
//            ErrorMsg aMsg = (ErrorMsg)a.value;
//            ErrorMsg bMsg = (ErrorMsg)b.value;
//
//            return new ErrorOnlyMsgRight(Stream.concat(aMsg.errorMsgStream, bMsg.errorMsgStream));
//        }
//    }


}
