package jeffrey.mathsymbolsdiscordbot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
	public static JDA jda;
	public static String prefix = "~";
	
	//Main method
	public static void main(String[] args) throws LoginException{
		jda = JDABuilder.createLight("MTA4MTYzODE4MjQ0MzA0NDk3Ng.GaU4h6.bch9PA8S4xbti-dq6_bdLIMT1z1C_wZNeOIo7E", GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS).build();
//		jda.getPresence().setIdle(true);
		jda.getPresence().setActivity(Activity.playing("Conversions"));
		jda.addEventListener(new Commands());
		
	}
}
