/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fly.game_logic.main;

import fly.com.object_engine.struct.CreateHandler;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 *
 * @author Administrator
 */
public class CreateHandlers {

    public static void main(String[] args) {
        try {
            new CreateHandler().execute();
        } catch (MojoExecutionException | MojoFailureException ex) {

        }
    }
}
