package me.nrz.design_patterns._02_structural_patterns._09_decorator._01_before;

/**
 * 단일 상속에서 두 기능을 Trim, SpamFilter 두 가지를 모두 수행해야한다면 또 클래스를 만들어야함
 */
public class Client {

    private CommentService commentService;

    private boolean enableSpamFilter;

    private boolean enableTrimming;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    private void writeComment(String comment) {
        commentService.addComment(comment);
    }

    public static void main(String[] args) {
        Client client = new Client(new SpamFilteringCommentService());
        client.writeComment("오징어게임");
        client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        client.writeComment("http://whiteship.me");
    }

}
