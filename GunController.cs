using System.Collections;
using System.Collections.Generic;
using System.Data;
using UnityEngine;

public class GunController : MonoBehaviour
{
    public float rotSpeed;

    private Vector3 myRotx;
    private Vector3 myRoty;

    public GameObject bulletPrefab;
    public float bulletSpeed;

    // Start is called before the first frame update
    void Start()
    {
        myRotx = Vector3.zero;
        myRoty = Vector3.zero;
        //bulletPrefab = GameObject.Find("Bullet");
    }

    // Update is called once per frame
    void Update()
    {
        float mx = Input.GetAxis("Mouse X");
        Vector3 r = Vector3.up * mx;
        myRotx += r * Time.deltaTime * rotSpeed;
        //transform.localEulerAngles = myRotx;
        

        float my = Input.GetAxis("Mouse Y");
        Vector3 r2 = Vector3.right * -my;
        myRoty += r2 * Time.deltaTime * rotSpeed;
        if (myRoty.x > 80)
            myRoty.x = 80;
        if (myRoty.x < -80)
            myRoty.x = -80;
    
        transform.localEulerAngles = new Vector3(myRoty.x, myRotx.y, 0);

        if (Input.GetButtonDown("Fire1"))
        {
            GameObject g = Instantiate(bulletPrefab, transform.position, Quaternion.identity);
            g.GetComponent<Rigidbody>().velocity = transform.forward * bulletSpeed;
        }
        
    }

}
