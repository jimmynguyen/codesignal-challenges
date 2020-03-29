import java.util.stream.IntStream;

public class AmendTheSentence {
	public static void main(String[] args) {
		String[] input0 = new String[] {"CodesignalIsAwesome", "Hello", "vSKwWDjwIerQKMgVaAniorRJlerbKpDgvyKBLPNwSRWtylqKewNFtERNuUBBHAsGkTSSfdhQHJYvAighAdeG", "iFvFAxtViLJDuWWXJesppOcLVdRAJZwBobdczkkWSPHzFLfyvmJYPdqYqRKKvLGYLwEFXcJiyYWLqjBvHjeqE", "iEiMCyKAdsfGMPa", "JhBkPBaozMnBqEWiIaOEje", "tfRZGdYurvrVyEuHbOJcaXnZrsEUr", "VizQEogigkRZJacVELulHjG", "DLwgqUxVFFNjbfMSuRuVhWZKVWSfLQrTXUxXdGJErkxWTzGAnbIGQeivRcdBbKrknbsdFRjzXAvqUDStpXx", "VEOwBXWxDTfDTnQZRKdnrOqPBSGuioJYdmISCoIpgXCLXNgnHQnxSntODxGZtimkoOeYlAHUuAwwOhmMkmxeBqdsxRynA", "kxGVMuoGggwhhsT", "sVHiQhPFQrjirEfcVRZbPwdNhHHiq", "bFLHXlURIOoBJdwYpBpecxrplXNowNtwDVloJNgnUNBNDMTCnhmcPtuTWtgEYXyZlbRoBzoulOttIaEImRYSOSKpJyfBM", "JklCwLha", "ILTfwHHaJzHrRWXgZWWJevoCkYBpXPPrrfZUTOJ", "RUqOPCVENqXwvTVhpcnUtisPBt", "WhOVxJmrmxWRXWMCQyLHJHJvXmOyvgcNRrvNcCwXKEMDUNpuYRbczfxfFTlSLhsvXOxhyBSmwAFIaVhHQFsZEYOKpERRLGMgNCTU"};
		String[] expectedOutput = new String[] {"codesignal is awesome", "hello", "v s kw w djw ier q k mg va anior r jlerb kp dgvy k b l p nw s r wtylq kew n ft e r nu u b b h as gk t s sfdh q h j yv aigh ade g", "i fv f axt vi l j du w w x jespp oc l vd r a j zw bobdczkk w s p hz f lfyvm j y pdq yq r k kv l g y lw e f xc jiy y w lqj bv hjeq e", "i ei m cy k adsf g m pa", "jh bk p baoz mn bq e wi ia o eje", "tf r z gd yurvr vy eu hb o jca xn zrs e ur", "viz q eogigk r z jac v e lul hj g", "d lwgq ux v f f njbf m su ru vh w z k v w sf l qr t x ux xd g j erkx w tz g anb i g qeiv rcd bb krknbsd f rjz x avq u d stp xx", "v e ow b x wx d tf d tn q z r kdnr oq p b s guio j ydm i s co ipg x c l x ngn h qnx snt o dx g ztimko oe yl a h uu aww ohm mkmxe bqdsx ryn a", "kx g v muo gggwhhs t", "s v hi qh p f qrjir efc v r zb pwd nh h hiq", "b f l h xl u r i oo b jdw yp bpecxrpl x now ntw d vlo j ngn u n b n d m t cnhmc ptu t wtg e y xy zlb ro bzoul ott ia e im r y s o s kp jyf b m", "jkl cw lha", "i l tfw h ha jz hr r w xg z w w jevo ck y bp x p prrf z u t o j", "r uq o p c v e nq xwv t vhpcn utis p bt", "wh o vx jmrmx w r x w m c qy l h j h jv xm oyvgc n rrv nc cw x k e m d u npu y rbczfxf f tl s lhsv x oxhy b smw a f ia vh h q fs z e y o kp e r r l g mg n c t u"};
		assert input0.length == expectedOutput.length : String.format("# input0 = %d, # expectedOutput = %d", input0.length, expectedOutput.length);
		IntStream.range(0, expectedOutput.length).forEach(i -> {
			String actualOutput = amendTheSentence(input0[i]);
			assert actualOutput.equals(expectedOutput[i]) : String.format("amendTheSentence(\"%s\") returned \"%s\", but expected \"%s\"", input0[i], actualOutput, expectedOutput[i]);
		});
		System.out.println(String.format("PASSES %d out of %d tests", expectedOutput.length, expectedOutput.length));
	}

	static String amendTheSentence(String s) {
		String t = "";
		for (char c : s.toCharArray()) {
			if (c >= 'A' && c <= 'Z') {
				t += (t.isEmpty() ? "" : " ") + (char)(c - 'A' + 'a');
			} else {
				t += c;
			}
		}
		return t;
	}
}
