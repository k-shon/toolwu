package top.kshon.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        System.out.println("加密:"+charSequence.toString());
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        System.out.println("解密:"+charSequence.toString());
        return s.equals(charSequence);
    }
}
