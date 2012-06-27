package net.therap.command;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/27/12
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImportCommand {
    private MultipartFile vcard;

    public ImportCommand() {
    }

    public MultipartFile getVcard() {
        return vcard;
    }

    public void setVcard(MultipartFile vcard) {
        this.vcard = vcard;
    }
}
