package com.cipher.aimkingbackend.utill;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EncryptionDecryption331 {
  private static final String FCODE =
      "FCODE000000801125d0083805b299b7398bb2d4c202c2DD0CCDF8E704FEDF51367C266E2233A642B9B7DF9683BEB00DC42610430EFE758C9F75046E6DB06E675B3772F1EF1FF5";
  // private static final String FCODE1 = "FCODE000000764ad986096df99ea3a45400ea87c669c4DD0CCDF8E704FEDF51367C266E2233A642B9B7DF9683BEB00DC42610430EFE758C9F75046E6DB06E675B37";
  // private static final String FCODE1 = "FCODE00000080b7fb83a6d24e0d7a207edb33babd93953EF434B6CE5A3D7C2380618F53258BCCD481B99C49667E72917261C52D4235A46DB03941EAF310B669B2EDDA4C22F5B5";
  private static final String FCODE1 =
      "FCODE000000801125d0083805b299b7398bb2d4c202c2DD0CCDF8E704FEDF51367C266E2233A642B9B7DF9683BEB00DC42610430EFE758C9F75046E6DB06E675B3772F1EF1FF5";
  private static final String FCODERAIS =
      "FCODE00000080a09f7ebfafaa9293ecf59090fe23a796559DF27F2A2A006C55616E0CA34283158F349CEFBA332F08A1973D4BC8D9F92C69F40D1980BF81AD45FA2839908F61FB";
  public static String text =
      "{\"result\":{\"\\u0006\\u0007A\\u0002\":\"3582-SBEEElhGA1IBUARHG0oXURJfE1RSDQVbAgYAABUcFQIRCUdSVgYHVgRVAgRdUA0GA1RXFBVHABcJFQEHDwJoVwdRDERAGQ==\",\"\\u000f\\u0003F\\u0010Q\\u0001V\":\"S\",\"\\u0011\\u0012T\\u0017E\\u0015\":\"PV\\u0005\",\"\\t\\u0003L\":\"[R\\u0000T\\u0002\\u0002\\u0005WWQQ\\u0004\\u0007\\tWWTSSSV]\\u0000\\u0002\\u0001\\u0006\\u0004\\u000fQ\\bTR\",\"\\u0007\\u001eE\\nB\\u001fg\\u000b\\f\\u0003\":\"1\\u0007AC\u007F\\u0005GBSPB\\u0002T\\u000b\\u0002FS\\u0007\\fUS\\u0002\\t\\t\\u0012t/m\\u0019\\t\\u0002VRF\\u001d _\\tA\\u0006\\b\\b\\u0003D\\u0001]\\u00163\\fX@\\u0003\\u0013KY\\\\\\u0012g\\u000bTW\\u0010\",\"\\u000e\\u0005j\\u0017I\\u0016V\":\"Q\",\"\\u000e\\u0005j\\u0014X\\u000fG\\u0007\":\"\\u0012\\tZ\\u000f\\u001e\\bG\\u0012O\\t\\u0010WKZ[H\\u0011TD\\u0003\\u000f_\\u0016][]\\u000bZ^PB\\u0016\\u0016HV\\f]\\u0014V\\u0016N\\n\\u000bF\\u0001\\u0014U\\t\\fW_\\u0001OHW_^\\u001d\\u000fP\\\\PQ\\n\\u000b\\u0016E\\u0017\\u001f\\u000b\\\\\\u0000\\b\\n\\u0007\\u001d\\bP@\\u0003LAY\\t\\r\\u0016UY\\\\Z\\u0001U[IB\\u0012M\\u0000T\\u0000U\\u0004\\\\\\r\\n\",\"\\u0017\\u0016j\\u0015S\\tW\\u0007\":\"QS\\rQ\",\"\\u0017\\u0016j\\u0015^\\u0007^\\u0007\":\"WS\\u001bZ\\u001eV\",\"\\u0001\\u0010Q\\u0006\\\\\\u0012R\":\"UT\\u0005S\"}}";
  static String request =
      "{\"a\":\"\\u0017[<Z\\u001b_\\u0019\\\\\\u0015\",\"b\":\"\\u0012M0E\\u001e@\\fC\\u0015\",\"c\":\"D\\u00005T\\u001a\\u0006L\\u0004U\\u0000^\\u0000S\\u0006V\\u0000\",\"d\":\"3617_64bit\",\"e\":\"L\\u00005VA\\rLPP\\u0000P\\u0006Z\\u0003\\u0000\\b\",\"f\":\"F\\u000e0\\u0005H\\u0007\\u001cPURP\\u0003\\u000f\\u0004R\\u000f\",\"g\":\"C\\u000e5\\u0005K\\fB\\u000f\\u0000\\u0002VS[\\u0000\\u0003\\n\",\"h\":\"C^bVHPJRPTW\\u0006[U\\u0002^\"}";
  static String text2 =
      "{\"result\":{\"\\u001bU\\u000bF\\u0005R\\u0006\":\"\\u0005E\\u001bV\\u0001F\\u0010\",\"\\u0005D\\u0019A\\u0011F\":\"D\\u0000H\"}}";
  static String text3 =
      "{\"result\":{\"\\u0001S\\u0015\\u0005\":\"V\\u0004PR\\u0018\\u0000t%\\u0005v\\n[S\\u0001r\\u0000VZQvt\\u0000\\u0001qt\\u0004r\\u0004\\u000f}U'WqT!\\u0007\\u0007\\u0006\\\"\\u0005s\\u0006&\\\\v\\u0001\\u0000V[Ur\\u0001v\\u000b\\u000bq\\u0003\\u0002\\u0004\\b\\b$Q!\\n\\\"!\\u0007\\u0002\\u0002]s\\u0005\\u0007R'\\u0005t\\u0001VPZ\\u0001\\u0007\\u0001w\\u0006\\u0002w\\n\\f\\u000f\\f$VW\\u0000#W\\u0004\\u0002sQ\\u0004s\\u0003%\\\\qr\\u0000US%s\\u0006\\u0001sw\\u0001u\\u0007t|}UU'\\u0000UVq\\u0002\\u0003Q\\u0006\\u0003\\u0005RV\\u000f\\u000e\\u0006]&Wsq\\u0007v\\u0006s\\u0007\\u0001\\u0001\\r\\tVZ'\\u0003\\\"%q\\u0005\\u0003U\\u0006\\u0001vTT\\u000e\\u0001q&%%\\t\\u0004w\\u0002\\nrw\\u0000p\\u0001~ZPVqP&\\u0004\\u0001\\u0004U\\u0005\\u0002\\u0006WTr\\u000f\\u0003Q  \\u0005\\u0000\\u0006\\u0005\\u0000rv\\u0000\\u0002\\bzR S\\u0006RRt\\u0004\\u0007U\\u0005q\\u000b&RsuwUTT\\u0006\\u0000us\\u0005\\u0004\\u000b\\u0004\\u0001\\r\\nZ\\\"#\\u0004'Twpw'pt\\u0003&]\\u0000\\u0005\\u0002UTR\\u0003r\\f\\u0001svq\\u0002t\\f\\t  '\\u0003SU\\u0002\\u0000\\u0001Ur\\u0000pSS\\u0006\\u000e\\u0000T!V\\t\\u000e\\u0005t\\u000b\\u0003p\\u000b\\u0007|\\u0000$Z]pR\\\\\\f\\u0007\\u0001'\\ts\\u0001U$\\u000fpq' W\\u0001\\u0006\\u0005\\u0001v\\u0000rup\\r\\u0001P\\\"\\\\\\u0002 Rp\\u000ewTp\\f\\u0003WT\\u0004\\u000ew][W\\u0000sr\\u0004tv\\n\\nw~\\u000fQ!'\\u0001\\\"Qv\\u0000\\u0000W\\u0002\\u0004v\\\"V\\u0003u\\f'W'\\u0000r\\f\\u000bss\\u0002q\\r\\r\\u0000Z&R\\u0001X \\u0006\\u0001s!\\u0000\\u0000\\u0000!T\\u0001\\u0002t\\\"PR\\u0002\\u000f\\u0002\\u0003\\ntuv\\u0005\\b~'RRsR\\\\\\f\\u0001uV\\b\\u0006\\u0000RSu\\u0004wWP[v\\u0005p\\u0002\\u0000r\\u0001us\\b|&'#sPP\\u0006r\\u0003U\\u0000\\u0005\\u000bT'\\u000f\\u0005pU&Uq\\u0005pq\\u0002\\u0001\\u0004\\u0003\\r\\u000b}VPUsYS\\u0006\\u0006u'\\u0003\\u0005tU$\\u000e\\u000fw\\\\\\\"P\\u0001tp\\u0006pr\\u000b\\u0004\\u0005\\u000b} TV\\u0004PQ\\f\\u0004t\\\"tvwP$\\u000eu\\u0003P%P\\u0006sww\\u0007uuqv\\n\\u0001&TT\\u0007 Wsw\\u000f'\\u0003t\\u0005'Wu\\u0003\\u0001'ZUs\\u0006\\u0005\\u000bw\\u000e\\u0000\\u0006v\\u000b~QSQ\\u0000#W\\r\\u0005\\u0002 uv\\u0004['\\u0003\\u0000\\u0005\\\\!Vv\\u000e\\u0003\\u000bw\\u0007\\u0004\\u0004\\u0006\\f{QWQ\\u0004VPq\\u0004tS\\u0007\\u0004\\u0005S'\\u0005u\\u0007PQ&\\u0003\\u0006\\u0006\\nwq\\u0000vw\\r\\fWRU\\u0004'\\\"s\\u000fw&u\\u0000\\u0003TT\\u0007t\\u0004]S!\\u0001\\u0002p\\u0001q\\u0006\\u0002r\\f\\t}'R#\\u0007W!\\u0000\\u0004\\u0005R\\u0006\\f\\u0003RSv\\u0007\\u0004\\\"PR\\u0002swqw\\u000e\\u0003r\\u0001\\u000e\\rQS]\\u0000TTv\\u0006\\u0001Q\\u0002\\u0000sZUqu\\u0006T\\\" tu\\u0004\\u0000p\\u0002\\u0007\\u0006\\u0002|\\u000f[PSq$]\\fr\\u0001U\\u0000v\\u0000R q\\u000e\\rV[Uu\\u0004\\u0002vt\\u0001\\u0006w\\u0004}\\u0001Z[\\\\sRW\\u0000w\\u0007%\\u0000\\u0006wSQu\\u0005\\u0005U&Vs\\u0001\\u0000\\u0007\\u0006\\u0004\\n\\u0006w~\\u000eZQ#\\u0007#R\\u0007\\u0006\\u0004 \\u0000v\\u0007U!\\u0007\\u0004\\u0001Q[V\\u0005\\u000e\\u0004\\u0003p\\u0004\\u0001\\u0002\\r~\\u000fV!&\\u0003X \\u0007s\\u0003\\\\\\u0003\\f\\u0002Z]\\u0003\\u000e\\f'[&\\u0006\\u0005qvv\\u000e\\u0002\\u0004\\u0005\\b\\u0001V'\\\\\\nXW\\u0001p\\u0003Su\\u0004\\u0004&R\\u0006\\u0005\\u0005\\\\ZPu\\u0006\\u0003\\u0002\\u0005q\\u0004vt\\bz'S#s\\\"U\\u0005\\u000e\\u0004\\\\\\u0006psSS\\u0000\\u0007\\rW\\\"\\\"\\u0006u\\u0006qwqp\\u0002\\u0000\\u000b}ZV'w$]\\ft\\u000f&\\u0001\\rvT!rut!W!r\\u0000qpp\\u0007\\u0003\\u0003s{\\fS&VwWP\\u0001\\u0002\\u0003Pw\\u0006\\u0003UUsu\\u0005\\\\!!\\u0004t\\rps\\u0006wqq\\t\\tV!&\\u0003SUvs\\u0001&r\\u0004\\u0004&U\\u0006\\u0002\\u0007 'P\\u0005t\\u0006\\u0006w\\u000fvut\\t\\u000b'WV\\u0000P'\\f\\u0005\\u0003'\\u0005\\r\\u0002W \\u0007\\u0007tRTV\\u0004\\u0000uq\\n\\u0004vwt\\b}SS$\\u0003$V\\r\\u0000sUw\\u0000\\u0003TR\\u0004\\u000f\\u0000]ST\\u0001t\\u0000\\u0005\\u0001\\u0002u\\u0007\\u0006z\\u000e V]t#%\\u0006\\u0001\\u0000\\\"\\u0004vqQR\\u0001\\u0000tR\\\" v\\u0006\\u0007\\u0002\\u0003\\u0006u\\u0004v\\u000b\\rZ[V\\u0006S&\\r\\u000f\\u0006Tp\\u0005\\u0006[&r\\u0000\\u0006PWU\\u0005t\\u0005\\u0003v\\u0000\\u0003\\u0002\\u0007z\\u000b! V\\u0005U&\\u0002ww&\\tw\\u000b['s\\u0007\\u0007&\\\"V\\t\\u0002q\\u0007qv\\n\\u0002\\u0002|\\u0001U'U\\u000bS\\\"\\u0001\\u0000\\u0004\\\"\\u0001\\u0000\\u0006\\\"]\\u0007p\\u0006S\\\" \\u0004\\u0002\\f\\n\\n\\u0000\\u0001qw\\u000by$V$pQ'\\u0003\\u0004u!\\u0001\\u0002\\u0002PP\\u0004\\u0000\\rQ&'\\u0002\\u0004w\\n\\u0005\\u0006\\u0004\\u0005\\r}}RRQ\\u0007'Vw\\u0001p!\\u0006\\u0007tPV\\u0002\\u0005w W\\\"\\u0006\\u0005\\u0002vs\\u0002p\\u000b\\f{\\u0001UPR\\u0006#%\\u0003\\u0000\\u0007%u\\u0002\\u0002R\\\\\\u0001\\u0006\\u0000 & qu\\u0005\\u0004w\\u0003\\u0004\\u0002\\u0004\\b|TR&\\u0004S%\\r\\u0001u\\\\\\tt\\u0001R&\\u0001rp!Z!\\u0004\\u0000\\u0003tv\\u0000\\u000b\\n\\u0002\\t\\u000e T!\\u0000PQp\\u0000\\u0006\\\\t\\u0006\\u000bWQ\\u0005s\\u0006]\\\"\\\"r\\u0006\\r\\u0004t\\u0005vqq\\u000f\\n[SUqWU\\fr\\u0000V\\u0004w\\u0000PUr\\u0006\\r%![\\bqv\\u0004\\u0000q\\u0002\\nv\\bz$TQv#Pq\\u0004\\u0005T\\u0002\\u0000t!#\\u000er\\f ![qr\\u0005wqs\\u0001\\u0004q\\u000fz!%U\\n$&wpw'w\\u0006\\u0000T#\\u0004\\u0002wVWZ\\b\\u0003\\u0001\\u0003v\\u000f\\u0002\\u0003\\u0006}\\u0000TS \\n#W\\u0004ts \\u0004\\u0007pQUssqWS&\\u0004\\u0004us\\u0004\\u0000\\n\\u0006\\u0000z|UVRwQS\\u0006\\u0000\\u0002\\\\\\tw\\u0002!S\\u0005\\u0006\\u0001R&\\\"u\\u0006vvsuv\\u000b\\u0000\\u0001\\f!SUsSQ\\f\\u0006\\u0002'\\u0007\\u0005\\u0004S q\\u0002\\f'UZ\\u0007\\u0003\\u0006\\u0006\\nspwv\\tzVS \\u0003%%vw\\u000f!\\u0004\\u0001\\u0003&&\\u0006\\u0007tQZZv\\u000ew\\u0000w\\u0003\\u000bu\\u0004|\\u000bRPS\\n%'\\u0001\\u0003\\u0001%\\t\\u0003\\u0000PU\\u000fpwP[U\\tsw\\u0005t\\u0001\\u0002\\n\\u0003\\n\\u000f R&\\u0007RWq\\u0001rQ\\u0001\\u0007\\u0004%V\\u0001\\u0002vSRWtvpqv\\u0005urt\\u0000{&SS\\u000bTR\\u0000sp\\\"\\u0000q\\nUQ\\u0005\\u0007\\u0006VR[\\u0005u\\u0007qq\\u0000\\u0007q\\f\\r\\u000b'U&\\u0006U\\\"s\\u0000\\u0000 wsvQQ\\u0007\\u0003vT'%\\u0000\\u000fusv\\u0000rp\\u0004\\tzTP\\\\\\u0001$W\\fs\\u0005Ww\\u0003tT]\\u0001\\u0000\\u0004Q Zss\\u0002w\\u0002\\u0003\\u0006v\\f\\u000e\\u000e&%$pW&w\\u0001\\u0000Ss\\u0001\\u0003R!\\u0001\\u0007tQZ&s\\u0004\\f\\u0007q\\u0006u\\u0006s~\\u000bW Q\\u0005\\\"S\\u0006\\u000e\\u000e \\u0005t\\u0000['s\\u000et ZU\\tsw\\u0007\\u0004\\u0002r\\u0000py\\u0000SRQ\\u0007%Str\\u0003Srt\\u0007%Rr\\u0001\\f\\\"!&\\u0006\\u000fq\\n\\u0002\\u0000\\u0002r\\u0002\\u0001\\nW!RpQ\\\"\\u0000\\u0003tWwtvZS\\u0003\\u000fs%WP\\u0004\\u0000\\u0006\\u0001\\n\\u000er\\u0002t{\\tZ&Rv$&\\u0004\\u0007\\u0004T\\b\\u0000s'#v\\u000f\\u0004] \\\"s\\u0001\\u0000\\u0006\\n\\u000f\\u0000ut\\u000ezT U\\u0002T'q\\u0004\\u0005R\\tvq $\\u0004\\u0002\\f'\\\" \\u0005\\u0001\\u0005\\u0000qv\\u0007\\u0003p\\t\\fQ Q\\u0003TP\\u0007p\\u0004]pqp P\\u000f\\u000e\\fVZUrq\\u0000tt\\u000euw\\u0005~\\u0001' S\\u0007PS\\fws%u\\fp\\\"R\\u0003\\u0006w%WW\\u0003\\u0000v\\u0001s\\u0004vu\\r\\t\\nRZUqVU\\u0000\\u0007p\\\\r\\u0001\\u0001Q$\\u0000\\u0003\\rS%[q\\u0005rw\\u0002t\\nr\\u0000\\u0000\\nZ'Qw%]\\f\\u0007\\u000eWs\\ftP\\\\rtq&S!\\u0000\\u0000\\u0001\\u0001\\u0005vr\\u0003\\u0000\\u0000\\tUR \\u0007YV\\u0002\\u0001sS\\u0001\\u0001\\nV\\\\\\u000e\\u0002\\f]Z'\\u0001\\u0003\\u0005w\\u0003qr\\u0005\\u0000\\u0001zZ']tP]\\u0007\\u0003w \\u0005\\u0000\\n S\\u0003\\u0002\\u0006QU \\u0005\\u0007\\u0003wp\\u0003\\u0002qqy\\u000fVQWt#Wt\\u0006pSr\\u0002sVP\\u0006\\u0003\\u0002UPPv\\u0002\\u0003tq\\u0004\\u0005\\u0006\\u0006|}ZUR\\u0000%'\\r\\u000e\\u0005\\\\r\\r\\u0006W!\\u000f\\u000evQ&'\\u0007s\\f\\u000btq\\u0007\\u0005w\\u0001\\b&\\\"Q\\u0004TV\\u0003\\u0000\\u0002U\\b\\u0000\\n& s\\u000esP Wq\\u0004vsvrrq\\u0000\\u0000|PU'\\u0000$Uwuw&\\bq\\nVU\\u0002\\u000f\\u0007%!R\\u0007q\\u0001pv\\u0003\\u0001\\u0004wzzUUW\\u000b\\\"Tw\\u000f\\u0000U\\u0004\\u0000sWU\\u0005\\u0000t %Z\\u0004\\u000e\\fw\\u000b\\u000fqqq\\u0001{R'WsT \\f\\u000f\\u000f!\\u0001p\\u0001UQt\\u0007sSQ&t\\u0002q\\u0005\\u0003t\\u0004\\u000b\\u0006}~[S!w'\\\"w\\u0004\\u000eP\\u0002\\u0000t[]u\\u0003\\u0001S\\\"Rr\\u0002\\u0001\\n\\u0001\\u0004wr\\r\\u000fzQST\\u0004Y'\\u0007\\u0001t \\u0007\\u0004w[!\\u0000\\u000ewQ%&\\u0006\\u0002\\fw\\u0007\\u0000\\n\\n\\u0003\\b\\f#%Vt%Us\",\"\\bW\\u0012\\u0017TQS\":\"U\",\"\\u0016F\\u0000\\u0010@E\":\"W\\u0002Q\",\"\\u000eW\\u0018\":\"P\\u000b\\u0004\\u0005\\u0000USUS\\u0000SSS\\u000f\\u000eVR\\u0007VVV\\u0002\\u0004\\u0001\\u0004\\u0006\\u0003\\u0006\\fZ\\u0003Q\",\"\\u0000J\\u0011\\rGOb\\r\\\\P\":\"2W\\u0005DzUBD\\u0003\\u0006\\u0012QU\\u0005\\u0002\\u0015TVY\\u0004\\u0003\\u000e\\u0007\\n\\u0017t~a\\u0013\\bRSU\\u0012I'ZYD\\u0000X[S\\u0017\\u0000S\\u0016`\\n\\n\\u0015UEGS^\\u0017gZX]\\u0011\",\"\\tQ>\\u0010LFS\":\"V\",\"\\tQ>\\u0013]_B\\u0001\":\"\\u0015]\\u000e\\b\\u001bXB\\u0014\\u001fZ@\\u0004JT[\\u001b\\u0017\\u0006\\u0011UYS\\u001c_^]ZVTQ\\u0012\\u0013\\u0011\\u001c\\u0002\\u000bXDS\\u0010\\u001eY[\\u0015\\u0000\\u001aUZ\\n\\u0005\\nW\\u0019D]][\\u001d^\\\\VQ\\u0001\\u000f\\fB\\u0011\\u0010\\u001a[Y\\u0006XYWN\\t^@PJ\\u0013\\f_[\\u001a_[YZPYQH\\u0012\\u0017JT\\u0000\\u0007PTY\\u000bZ\",\"\\u0010B>\\u0012VYR\\u0001\":\"V\\u0007YV\",\"\\u0010B>\\u0012[W[\\u0001\":\"P\\u0007O]\\u001b\\u0006\",\"\\u0006D\\u0005\\u0001YBW\":\"R\\u0000QT\"}}";
  static String eightBallpool10Response =
      "{\"result\":{\"\\u0006\\u0007A\\u0002\":\"3616-SBEEElhGA1IBUARHG0oXURJfE1RSDQVbAgYAABUcFQIRCUdSVgYHVgRVAgRdUA0GA1RXFBVHABcJFQEEBgZoVwdRDERAGQ==\",\"\\u000f\\u0003F\\u0010Q\\u0001V\":\"S\",\"\\u0011\\u0012T\\u0017E\\u0015\":\"PV\\u0005\",\"\\t\\u0003L\":\"[R\\u0000T\\u0002\\u0002\\u0005WWQQ\\u0004\\u0007\\tWWTSSSV]\\u0000\\u0002\\u0001\\u0006\\u0004\\u000fQ\\bTR\",\"\\u0007\\u001eE\\nB\\u001fg\\u000b\\f\\u0003\":\"1\\u0007AC\u007F\\u0005GBSPB\\u0002T\\u000b\\u0002FS\\u0007\\fUS\\u0002\\t\\t\\u0012t/m\\u0019\\t\\u0002VRF\\u001d _\\tA\\u0006\\b\\b\\u0003D\\u0001]\\u00163\\fX@\\u0003\\u0013KY\\\\\\u0012g\\u000bTW\\u0010\",\"\\u000e\\u0005j\\u0017I\\u0016V\":\"Q\",\"\\u000e\\u0005j\\u0014X\\u000fG\\u0007\":\"\\u0012\\tZ\\u000f\\u001e\\bG\\u0012O\\t\\u0010WKZ[H\\u0011TD\\u0003\\u000f_\\u0016][]\\u000bZ^PB\\u0016\\u0016HV\\f]\\u0014V\\u0016N\\n\\u000bF\\u0001\\u0014U\\t\\fW_\\u0001OHW_^\\u001d\\u000fP\\\\PQ\\n\\u000b\\u0016E\\u0017\\u001f\\u000b\\\\\\u0000\\b\\n\\u0007\\u001d\\bP@\\u0003LAY\\t\\r\\u0016UY\\\\Z\\u0001U[IB\\u0012M\\u0000T\\u0000U\\u0004\\\\\\r\\n\",\"\\u0017\\u0016j\\u0015S\\tW\\u0007\":\"QS\\rQ\",\"\\u0017\\u0016j\\u0015^\\u0007^\\u0007\":\"WS\\u001bZ\\u001eV\",\"\\u0001\\u0010Q\\u0006\\\\\\u0012R\":\"UT\\u0005S\"}}";
  private static String f1997O0oo0o0Oo = "t8V0x5z6c7f2j4a8s7d6h3k1m9p0q2r5";
  private static String f2000O0oo0o0Oo = "v0x5d5c7f2j4a8s7d6h3k1m9p0q2r5";
  private static HashMap<String, String> gameData;

  private static HashMap<String, String> gameDataEightBallPool10;

  public static void main(String[] args) {
    // HashMap<String, String> hashMap = new HashMap<>();
    //  OO00o0("180116365646441",hashMap);
    try {
      //   System.out.println(firstRequest(request));
      //  firstCall();
      //  secondCall();
      //  String fLogin =  generateFlogin(FCODERAIS, "abc", "pqr");
      //   System.out.println("Final Flogin = "+fLogin);
      //   System.out.println(getHashMap());
      //  System.out.println(getHashMapEightBallPool10());

      System.out.println(new String(new byte[] {-14, 62}));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
      data[i / 2] =
          (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
    }
    return data;
  }



  public static JSONObject firstRequest(String request) {

    try {
      /**
       *  "a" = "userName"
       *  "b" = "password"
       *  "c" = "androidId"
       *  "e" = "storage information"
       *  "f" = "Device build combination"
       *  "g" = "Device MediaDrm uniqueId"
       */


      JSONObject jsonObject = new JSONObject(request);

      HashMap<String, String> hashMap = new HashMap<>();


      Iterator<String> keys = jsonObject.keys();

      while (keys.hasNext()) {

        String key = keys.next();
        String value = jsonObject.getString(key);
        if (key.equals("a") || key.equals("b") || key.equals("c")) {
          hashMap.put(key, oO0Oo0o0(value));
        } else if (key.equals("e") || key.equals("f") || key.equals("g") || key.equals("h")) {
          hashMap.put(key, oO0Oo0o0(value));
        } else {
          hashMap.put(key, value);
        }

      }
      // System.out.println(hashMap);
      return new JSONObject(hashMap);


    } catch (Exception e) {
      e.printStackTrace();
      return new JSONObject();
    }
  }

  public static JSONObject firstRequestEightBallPool10(String request) {

    try {
      /**
       *  "a" = "userName"
       *  "b" = "password"
       *  "c" = "androidId"
       *  "e" or "HBD" = "storage information"
       *  "f" or "PDD" = "Device build combination"
       *  "g" = "Device MediaDrm uniqueId"
       *  "h" or "SD" = "Unknown"
       */


      JSONObject jsonObject = new JSONObject(request);

      HashMap<String, String> hashMap = new HashMap<>();


      Iterator<String> keys = jsonObject.keys();

      while (keys.hasNext()) {

        String key = keys.next();
        String value = jsonObject.getString(key);
        if (key.equals("a") || key.equals("b") || key.equals("c")) {
          hashMap.put(key, oO0Oo0o0(value));
        } else if (key.equals("e") || key.equals("f") || key.equals("g") || key.equals("h")) {
          hashMap.put(key, oO0Oo0o0(value));
        } else {
          hashMap.put(key, value);
        }

      }
      // System.out.println(hashMap);
      return new JSONObject(hashMap);


    } catch (Exception e) {
      e.printStackTrace();
      return new JSONObject();
    }
  }

  public static JSONObject secondRequest(String request) {

    try {

      JSONObject jsonObject = new JSONObject(request);

      HashMap<String, String> hashMap = new HashMap<>();


      Iterator<String> keys = jsonObject.keys();

      while (keys.hasNext()) {

        String key = keys.next();
        String value = jsonObject.getString(key);
        hashMap.put(key, oO0Oo0o0new(value));
      }
      // System.out.println(hashMap);
      return new JSONObject(hashMap);


    } catch (Exception e) {
      e.printStackTrace();
      return new JSONObject();
    }
  }



  public static Map<String, String> getHashMapEightBallPool55_10() {
    if (gameData != null) {
      return gameData;
    }
    HashMap<String, String> hashMap = new HashMap<>();
    try {
      JSONObject jsonObject = new JSONObject(text);

      jsonObject = jsonObject.getJSONObject("result");

      Iterator<String> keys = jsonObject.keys();
      while (keys.hasNext()) {
        String key = keys.next();
        String value = jsonObject.getString(key);
        hashMap.put(key, value);
      }

      JSONObject jsonObject1 = new JSONObject(OO00o0("b4bf77661d68531f", hashMap));
      System.out.println("JSON Output: " + jsonObject1.toString());
      hashMap = new HashMap<>();
      keys = jsonObject1.keys();
      while (keys.hasNext()) {
        String key = keys.next();
        String value = jsonObject1.getString(key);
        hashMap.put(key, value);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    hashMap.put("data",
        "3582-SBEEElhGA1IBUARHG0oXURJfE1RSDQVbAgYAABUcFQIRCUdSVgYHVgRVAgRdUA0GA1RXFBVHABcJFQEHDwJoVwdRDERAGQ==");
    gameData = hashMap;
    return hashMap;
  }

  public static Map<String, String> getHashMapEightBallPool55_9() {
    if (gameDataEightBallPool10 != null) {
      return gameDataEightBallPool10;
    }
    HashMap<String, String> hashMap = new HashMap<>();
    try {
      JSONObject jsonObject = new JSONObject(eightBallpool10Response);

      jsonObject = jsonObject.getJSONObject("result");

      Iterator<String> keys = jsonObject.keys();
      while (keys.hasNext()) {
        String key = keys.next();
        String value = jsonObject.getString(key);
        hashMap.put(key, value);
      }

      JSONObject jsonObject1 = new JSONObject(OO00o0("b4bf77661d68531f", hashMap));
      System.out.println("JSON Output: " + jsonObject1.toString());
      hashMap = new HashMap<>();
      keys = jsonObject1.keys();
      while (keys.hasNext()) {
        String key = keys.next();
        String value = jsonObject1.getString(key);
        hashMap.put(key, value);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    hashMap.put("data",
        "3616-SBEEElhGA1IBUARHG0oXURJfE1RSDQVbAgYAABUcFQIRCUdSVgYHVgRVAgRdUA0GA1RXFBVHABcJFQEEBgZoVwdRDERAGQ==");
    gameDataEightBallPool10 = hashMap;
    return hashMap;
  }



  private static void firstCall() {
    try {
      JSONObject jsonObject = new JSONObject(text);
      HashMap<String, String> hashMap = new HashMap<>();
      jsonObject = jsonObject.getJSONObject("result");

      Iterator<String> keys = jsonObject.keys();
      while (keys.hasNext()) {
        String key = keys.next();
        String value = jsonObject.getString(key);
        hashMap.put(key, value);
      }

      JSONObject jsonObject1 = new JSONObject(OO00o0("180116365646441", hashMap));
      //  JSONObject jsonObject1 = new JSONObject(OO00o0("5ce77e75a22006f1",hashMap));
      System.out.println("JSON Output: " + jsonObject1.toString());
      hashMap = new HashMap<>();
      keys = jsonObject1.keys();
      while (keys.hasNext()) {
        String key = keys.next();
        String value = jsonObject1.getString(key);
        hashMap.put(key, value);
      }

      hashMap = encrypt(hashMap, "180116365646441");

      jsonObject1 = new JSONObject(OO00o0("180116365646441", hashMap));
      JSONObject finalJson = new JSONObject(hashMap);
      //  finalJson.put("result", new JSONObject(hashMap));

      System.out.println("JSON Output: " + finalJson.toString());
      System.out.println("JSON Output: " + jsonObject);
      hashMap = new HashMap<>();
      keys = finalJson.keys();
      while (keys.hasNext()) {
        String key = keys.next();
        String value = finalJson.getString(key);
        hashMap.put(key, value);
      }

      jsonObject1 = new JSONObject(OO00o0("180116365646441", hashMap));
      System.out.println("JSON Output: " + jsonObject1.toString());



    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("=========================");

  }

  public static HashMap encrypt(Map<String, String> hashMap, String androidId) {

    return OO00o0(androidId, hashMap);

  }

  private static void secondCall() {
    System.out.println("========Second call======");
    try {

      JSONObject jsonObject = new JSONObject(text2);

      HashMap<String, String> hashMap = new HashMap<>();
      jsonObject = jsonObject.getJSONObject("result");

      Iterator<String> keys = jsonObject.keys();

      while (keys.hasNext()) {

        String key = keys.next();
        String value = jsonObject.getString(key);
        hashMap.put(oO0Oo0o0new(key), oO0Oo0o0new(value));
      }
      // System.out.println(hashMap);
      JSONObject jsonObject1 = new JSONObject(hashMap);
      System.out.println(jsonObject1);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public static HashMap OO00o0(String str, Map<String, String> hashMap) {
    String str2;
    HashMap hashMap2 = new HashMap();
    try {


      for (Map.Entry entry : hashMap.entrySet()) {
        hashMap2.put(O0oo0o0Oo((String) entry.getKey(), Il1i(str)),
            O0oo0o0Oo((String) entry.getValue(), Il1i(str)));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return hashMap2;
  }


  public static HashMap OO00o0New(String str, Map<String, String> hashMap) {
    String str2;
    HashMap hashMap2 = new HashMap();
    try {


      for (Map.Entry<String, String> entry : hashMap.entrySet()) {
        if (entry.getKey().equalsIgnoreCase("data")) {
          hashMap2.put(O0oo0o0Oo((String) entry.getKey(), Il1i(str)), entry.getValue());
        } else {
          hashMap2.put(O0oo0o0Oo((String) entry.getKey(), Il1i(str)),
              O0oo0o0Oo((String) entry.getValue(), Il1i(str)));
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return hashMap2;
  }


  public static String oO0Oo0o0(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char charAt = str.charAt(i);
      String str2 = f1997O0oo0o0Oo;
      sb.append((char) (charAt ^ str2.charAt(i % str2.length())));
    }
    return sb.toString();
  }

  public static String oO0Oo0o0new(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char charAt = str.charAt(i);
      String str2 = f2000O0oo0o0Oo;
      sb.append((char) (charAt ^ str2.charAt(i % str2.length())));
    }
    return sb.toString();
  }


  private static String O0oo0o0Oo(String str, String str2) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      sb.append((char) (str.charAt(i) ^ str2.charAt(i % str2.length())));
    }
    return sb.toString();
  }

  public static String Il1i(String str) {
    if (str == null) {
      return null;
    }
    return oOOOOOO0oO0(str.getBytes());
  }


  public static String oOOOOOO0oO0(byte[] bArr) {
    if (bArr == null) {
      return null;
    }
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(bArr);
      return o0o(messageDigest.digest());
    } catch (Throwable th) {
      th.printStackTrace();
      return null;
    }
  }


  private static String o0o(byte[] bArr) {
    if (bArr == null) {
      return null;
    }
    return oO0Oo0o0(bArr, 0, bArr.length);
  }

  private static String oO0Oo0o0(byte[] bArr, int i, int i2) {
    if (bArr == null || i < 0 || i2 < 0) {
      return null;
    }
    StringBuilder sb = new StringBuilder(i2 * 2);
    int i3 = i2 + i;
    while (i < i3) {
      String hexString = Integer.toHexString(bArr[i] & 255);
      if (hexString.length() == 1) {
        hexString = "0" + hexString;
      }
      sb.append(hexString);
      i++;
    }
    return sb.toString();
  }

  public static String generateHex(int number) {
    // Convert the number to hexadecimal and pad with leading zeros to ensure 4 characters
    return String.format("%04X", number);
  }

}
