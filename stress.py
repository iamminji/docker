import requests
import concurrent.futures

API = 'http://localhost:8080/take'
MAX_THREADS = 10
CONCURRENT_THREADS = 8


def send_api_request():
    print('Sending API request: ', API)
    r = requests.get(API)
    print('Received: ', r.status_code, r.text)


if __name__ == '__main__':
    with concurrent.futures.ThreadPoolExecutor(MAX_THREADS) as executor:
        futures = [executor.submit(send_api_request) for x in range(CONCURRENT_THREADS)]
