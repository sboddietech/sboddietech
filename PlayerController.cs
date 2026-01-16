using System.Collections;
using System.Collections.Generic;
using System.Runtime.CompilerServices;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class PlayerController : MonoBehaviour
{
    Rigidbody myBod;
    float health = 100;
    public float speed;
    Text gameOver;
    Text gameTimer;
    int num;

    Vector3 myRot;

    Transform greenTran;

    // Start is called before the first frame update
    void Start()
    {
        myBod = GetComponent<Rigidbody>();
        greenTran = GameObject.Find("GreenHealth").transform;
        gameOver = GameObject.Find("Lose").GetComponent<Text>();
        gameTimer = GameObject.Find("Timer").GetComponent<Text>();
    }

    // Update is called once per frame
    void Update()
    {
        if (transform.position.y <= 1.1f)
        {
            myBod.drag = 5;
            float h = Input.GetAxis("Horizontal");
            float v = Input.GetAxis("Vertical");
            Vector3 f = transform.right * h + transform.forward * v;
            f.y = 0;
            myBod.AddForce(f * Time.deltaTime * speed);

            if (Input.GetButtonDown("Jump"))
            {
                myBod.AddForce(Vector3.up * 7, ForceMode.Impulse);
            }
        }
        else
        {
            myBod.drag = 0;
        }

        //int num = 0;
        //num += 1;
        //gameTimer.text = "Timer: " + Time.deltaTime;
        timer();

            float x = Input.GetAxis("Mouse X");
        float y = Input.GetAxis("Mouse Y");
        Vector3 s = Vector3.right * y + Vector3.up * x;
        myRot += (s * Time.deltaTime * 360);
        if(myRot.x >15)
            myRot.x = 15;
        if(myRot.x <-15)
            myRot.x = -15;
        transform.eulerAngles = myRot;
    }

    public void damage(float d)
    {
        health -= d;
        if(health <= 0)
        {
            Time.timeScale = 0;
            gameOver.enabled = true;
        }
        greenTran.localScale = new Vector3(health / 100, 1, 1);
    }

    public void timer()
    {
        num += 1;
        gameTimer.text = "Timer: " + (num/60);
    }
}
