package jeffrey.mathsymbolsdiscordbot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
	public void onMessageReceived(MessageReceivedEvent event) {
		if(event.getAuthor().isBot()) return;
		String input = event.getMessage().getContentRaw();
		if(input.equals("~info")) {
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("Information");
			info.setDescription("Hello! I am Latexio. I can help you convert any math symbols");
			info.addField("Creators", "Asvin, Aayush, Andrew, Jeffrey", false);
			info.setColor(0xf45642);
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessageEmbeds(info.build()).queue();
			info.clear();
		}else if(input.indexOf("~") != -1){
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(convert(input)).queue();
		}
	}
	public static String convert (String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '~') {
                if (input.substring(i, i+3).equals("~pi")) {
                    output.append("π");
                    i+=2;
                } else if (input.substring(i, i+5).equals("~sqrt")) {
                    output.append("√");
                    i+=4;
                } else if (input.substring(i, i+6).equals("~theta")) {
                    output.append("θ");
                    i += 5;
                } else if (input.substring(i,i+6).equals("~cubed")) {
                    output.append("³");
                    i += 5;
                } else if (input.substring(i, i+8).equals("~squared")) {
                    output.append("²");
                    i += 7;
                } else if (input.substring(i,i+9).equals("~infinity")) {
                    output.append("∞");
                    i+=8;
                } else if (input.substring(i, i+10).equals("~integrate")) {
                    output.append("∫");
                    i+=9;
                } else {
                    output.append(c);
                }
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }
}
